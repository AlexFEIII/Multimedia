package com.example.multimedia.service.ServiceImpl;

import com.example.multimedia.domain.*;
import com.example.multimedia.domain.returnMessage.*;
import com.example.multimedia.repository.*;
import com.example.multimedia.service.CommentService;
import com.example.multimedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Collection;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private DocCommentRepository docCommentRepository;
    @Autowired
    private ForumCommentRepository forumCommentRepository;
    @Autowired
    private VideoCommentRepository videoCommentRepository;
    @Autowired
    private DocRelayRepository docRelayRepository;
    @Autowired
    private ForumRelayRepository forumRelayRepository;
    @Autowired
    private VideoRelayRepository videoRelayRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private ForumRepository forumRepository;
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private DocCUpvoteRepository docCUpvoteRepository;
    @Autowired
    private ForumCUpvoteRepository forumCUpvoteRepository;
    @Autowired
    private VideoCUpvoteRepository videoCUpvoteRepository;

    SensitivewordFilter sensitivewordFilter = new SensitivewordFilter();

    /*
    * 评论功能
    * */
    @Override
    public Map<Long,String> comment(String type, long objid, String content) {
        long userid = userRepository.findByUsername(userService.getUsername()).getId();
        long ruserid = docCommentRepository.findOne(objid).getUserid();
        content = sensitivewordFilter.turnWord(content);
        long id = 0;
        if (type.equals("doc")){
            DocComment docComment = new DocComment(deleteHTML(content),objid,userid,ruserid);
            docCommentRepository.save(docComment);
            id = docComment.getId();
        }else if (type.equals("forum")){
            ForumComment forumComment = new ForumComment(deleteHTML(content),objid,userid,ruserid);
            forumCommentRepository.save(forumComment);
            id = forumComment.getId();
        }else if (type.equals("video")){
            VideoComment videoComment = new VideoComment(deleteHTML(content),objid,userid,ruserid);
            videoCommentRepository.save(videoComment);
            id = videoComment.getId();
        }else if (type.equals("docR")){
            DocRelay docRelay = new DocRelay(deleteHTML(content),objid,userid,ruserid);
            docRelayRepository.save(docRelay);
            id = docRelay.getId();
        }else if (type.equals("forumR")){
            ForumRelay forumRelay = new ForumRelay(deleteHTML(content),objid,userid,ruserid);
            forumRelayRepository.save(forumRelay);
            id = forumRelay.getId();
        }else if (type.equals("videoR")){
            VideoRelay videoRelay = new VideoRelay(deleteHTML(content),objid,userid,ruserid);
            videoRelayRepository.save(videoRelay);
            id = videoRelay.getId();
        }else{
            return null;
        }
        Map<Long,String> map = new HashMap<Long,String>();
        map.put(id,content);
        return map;
    }

    /*
    * 回复 回复
    * */
    @Override
    public Map<Long,String> replyR(String type,String content,long objid,long rcommentid){
        long userid = userRepository.findByUsername(userService.getUsername()).getId();
        long ruserid = docRelayRepository.findOne(objid).getUserid();
        content = sensitivewordFilter.turnWord(content);
        long id = 0;
        if (type.equals("docRR")){
            DocRelay docRelay = new DocRelay(deleteHTML(content),objid,rcommentid,userid,ruserid);
            docRelayRepository.save(docRelay);
            id = docRelay.getId();
        }else if (type.equals("forumRR")){
            ForumRelay forumRelay = new ForumRelay(deleteHTML(content),objid,rcommentid,userid,ruserid);
            forumRelayRepository.save(forumRelay);
            id = forumRelay.getId();
        }else if (type.equals("videoRR")){
            VideoRelay videoRelay = new VideoRelay(deleteHTML(content),objid,rcommentid,userid,ruserid);
            videoRelayRepository.save(videoRelay);
            id = videoRelay.getId();
        }else{
            return null;
        }
        Map<Long,String> map = new HashMap<>();
        map.put(id,content);
        return map;
    }

    /*
    * 删除评论
    * */
    @Override
    public String deleteComment(String type,long docid,long commentid,long relayid) {
        User userDetails = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        if (type.equals("doc")){
            //如果文章是自己的可以删除||如果评论是自己的，可以删除||如果被回复的用户是自己，可以删除
            if (userRepository.findOne(documentRepository.findOne(docid).getUserid()).getUsername().equals(username) ||
                    userRepository.findOne(docCommentRepository.findOne(commentid).getUserid()).getUsername().equals(username) ||
                    userRepository.findOne(docRelayRepository.findOne(relayid).getUserid()).getUsername().equals(username)){
                docRelayRepository.delete(relayid);
                return "Y";
            }
            return "N";
        }else if (type.equals("forum")){
            if (userRepository.findOne(forumRepository.findOne(docid).getUserid()).getUsername().equals(username) ||
                    userRepository.findOne(forumCommentRepository.findOne(commentid).getUserid()).getUsername().equals(username) ||
                    userRepository.findOne(forumRelayRepository.findOne(relayid).getUserid()).getUsername().equals(username)){
                forumRelayRepository.delete(relayid);
                return "Y";
            }
            return "N";
        }else {
            if (userRepository.findOne(videoRepository.findOne(docid).getUserid()).getUsername().equals(username) ||
                    userRepository.findOne(videoCommentRepository.findOne(commentid).getUserid()).getUsername().equals(username) ||
                    userRepository.findOne(videoRelayRepository.findOne(relayid).getUserid()).getUsername().equals(username)){
                videoRelayRepository.delete(relayid);
                return "Y";
            }
            return "N";
        }
    }

    /**
     * @param type 类型，doc，forum，video
     * @param docid 该类型中文章的id
     * @param commentid 文章中评论id;
     */
    @Override
    public String deleteComment(String type,long docid, long commentid) {
        User userDetails = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        //如果文档是自己的可以删||如果评论是自己的可以删
        if (type.equals("doc")){
            //如果文章是自己的可以删除||如果评论是自己的，可以删除||如果被回复的用户是自己，可以删除
            if (userRepository.findOne(documentRepository.findOne(docid).getUserid()).getUsername().equals(username) ||
                    userRepository.findOne(docCommentRepository.findOne(commentid).getUserid()).getUsername().equals(username)){
                docCommentRepository.delete(commentid);
                return "Y";
            }
            return "N";
        }else if (type.equals("forum")){
            if (userRepository.findOne(forumRepository.findOne(docid).getUserid()).getUsername().equals(username) ||
                    userRepository.findOne(forumCommentRepository.findOne(commentid).getUserid()).getUsername().equals(username)){
                forumCommentRepository.delete(commentid);
                return "Y";
            }
            return "N";
        }else {
            if (userRepository.findOne(videoRepository.findOne(docid).getUserid()).getUsername().equals(username) ||
                    userRepository.findOne(videoCommentRepository.findOne(commentid).getUserid()).getUsername().equals(username)){
                videoCommentRepository.delete(commentid);
                return "Y";
            }
            return "N";
        }
    }

    //返回评论*3
    @Override
    public List<DCView> getDocComment(long docid, int pagenum) {
        List<DCView> dcViews = new ArrayList<>();
        boolean isLogin = true;
        MulUser mulUser = null;
        try{
            mulUser = userRepository.findByUsername(userService.getUsername());
        }catch (Exception e){
            isLogin = false;
        }
        Pageable pageable = new PageRequest(pagenum-1,20,new Sort(Sort.Direction.DESC,"id"));
        Page<DocComment> list = docCommentRepository.findByDocid(docid,pageable);
        for (DocComment docComment : list){
//            List<DocRUser> result = new ArrayList<>();
//            docRelays.clear();
//            List<DocRelay> docRelay = docRelayRepository.findByCommentidAndRcommentidEquals(docComment.getId(),0);
//            for (int i = 0;i < docRelay.size();i++)
//                docRelays.add(new DocRUser(docRelay.get(i),userRepository.findOne(docRelay.get(i).getUserid())));
//            for(DocRUser docRUser : docRelays){
//                result.add(docRUser);
//                findDSonRelay(result,docComment.getId(),docRUser.getDocRelay().getId());
//            }
//            if (result.size() == 0){
//                map.put(new DocCUser(docComment,userRepository.findOne(docComment.getUserid())),null);
//            }else{
//                map.put(new DocCUser(docComment,userRepository.findOne(docComment.getUserid())),result);
//            }
            List<DocRUser> docRelays = new ArrayList<>();
            List<DocRelay> docRelay = docRelayRepository.findByCommentid(docComment.getId());
            for (int i = 0;i < docRelay.size();i ++){
                MulUser user = userRepository.findOne(docRelay.get(i).getUserid());
                MulUser ruser = userRepository.findOne(docRelay.get(i).getReplyid());
                docRelays.add(new DocRUser(docRelay.get(i),user.getNickname(),user.getId(),ruser.getNickname(),ruser.getId()));
            }
            boolean flag = false;
            if (isLogin){
                if (docCUpvoteRepository.findByCommentidAndUserid(docComment.getId(),mulUser.getId()) != null) flag = true;
            }
            if (docRelays.size() != 0){
                dcViews.add(new DCView(list.getTotalPages(),list.getTotalElements(),flag,new DocCUser(docComment,userRepository.findOne(docComment.getUserid())),docRelays));
            }else{
                dcViews.add(new DCView(list.getTotalPages(),list.getTotalElements(),flag,new DocCUser(docComment,userRepository.findOne(docComment.getUserid())),null));
            }
        }
        return dcViews;
    }

//    public void findDSonRelay(List<DocRUser> result,long cid,long rid){   //递归查找文章子评论
//        try{
//            for(DocRelay docRelay : docRelayRepository.findByCommentidAndRcommentid(cid,rid)){
//                result.add(new DocRUser(docRelay,userRepository.findOne(docRelay.getUserid())));
//                findDSonRelay(result,cid,docRelay.getId());
//            }
//        }catch (Exception e){
//            return;
//        }
//    }

    @Override
    public List<FCView> getForumComment(long docid, int pagenum) {
        List<FCView> fcViews = new ArrayList<>();
        Pageable pageable = new PageRequest(pagenum-1,20,new Sort(Sort.Direction.DESC,"id"));
        Page<ForumComment> list = forumCommentRepository.findByForumid(docid,pageable);
        for (ForumComment forumComment : list){
            List<ForumRUser> forumRelays = new ArrayList<>();
            List<ForumRelay> forumRelay = forumRelayRepository.findByCommentid(forumComment.getId());
            for(int i = 0;i < forumRelay.size();i ++)
                forumRelays.add(new ForumRUser(forumRelay.get(i),userRepository.findOne(forumRelay.get(i).getUserid())));
            if (forumRelays.size() == 0){
                fcViews.add(new FCView(list.getTotalPages(),new ForumCUser(forumComment,userRepository.findOne(forumComment.getUserid())),null));
            }else{
                fcViews.add(new FCView(list.getTotalPages(),new ForumCUser(forumComment,userRepository.findOne(forumComment.getUserid())),forumRelays));
            }
        }
        return fcViews;
    }

    @Override
    public List<VCView> getVideoComment(long docid,int pagenum) {
        List<VCView> vcViews = new ArrayList<>();
        Pageable pageable = new PageRequest(pagenum-1,20,new Sort(Sort.Direction.DESC,"id"));
        Page<VideoComment> list = videoCommentRepository.findByVideoid(docid,pageable);
        for (VideoComment videoComment : list){
            List<VideoRUser> videoRelays = new ArrayList<>();
            List<VideoRelay> videoRelay = videoRelayRepository.findByCommentid(videoComment.getId());
            for (int i = 0;i < videoRelay.size();i ++)
                videoRelays.add(new VideoRUser(videoRelay.get(i),userRepository.findOne(videoRelay.get(i).getUserid())));
            if (videoRelays.size() == 0){
                vcViews.add(new VCView(list.getTotalPages(),new VideoCUser(videoComment,userRepository.findOne(videoComment.getUserid())),null));
            }else{
                vcViews.add(new VCView(list.getTotalPages(),new VideoCUser(videoComment,userRepository.findOne(videoComment.getUserid())),videoRelays));
            }
        }
        return vcViews;
    }

    //进行输入的心情中处理文本除需要的img html元素以外的删除。
    public String deleteHTML(String comment) {
        comment.replaceAll("<", "&lt");
        comment.replaceAll(">", "&gt");
        comment.replaceAll("&", "&amp");
        comment.replaceAll("\"", "&quot");
        comment.replaceAll("'", "&apos");
        return comment;
    }
}
