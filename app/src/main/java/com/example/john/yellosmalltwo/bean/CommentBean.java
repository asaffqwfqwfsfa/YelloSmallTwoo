package com.example.john.yellosmalltwo.bean;

import java.util.List;

/**
 * Created by john on 2018/6/25.
 */

public class CommentBean {

    /**
     * status : 200
     * message : 获取餐馆评论成功
     * data : [{"user_id":227,"id":29,"user_name":"jjjjj","avatar":"http://i.waimai.meituan.com/static/img/default-avatar.png","restaurant_id":32,"restaurant":"5ac5af803714cc2d644f4615","comment_data":"摸摸","order_id":375,"food_score":4,"delivery_score":4,"pic_url":["http://p3d0ne50u.bkt.clouddn.com/FrmvnNe2aXy7iMKLMeuK1JxnDwXT"],"add_comment_list":[],"comment_time":"2018-04-10T04:42:51.012Z","__v":0},{"user_id":324,"id":30,"user_name":"18037166365","avatar":"http://i.waimai.meituan.com/static/img/default-avatar.png","restaurant_id":32,"restaurant":"5ac5af803714cc2d644f4615","comment_data":"九年级可能加","order_id":471,"food_score":4,"delivery_score":4,"pic_url":[],"add_comment_list":[],"comment_time":"2018-04-10T04:42:51.012Z","__v":0},{"user_id":448,"id":32,"user_name":"993986077","avatar":"http://i.waimai.meituan.com/static/img/default-avatar.png","restaurant_id":32,"restaurant":"5ac5af803714cc2d644f4615","comment_data":"日发的方式发的撒饭阿萨","order_id":647,"food_score":5,"delivery_score":5,"pic_url":[],"add_comment_list":[],"comment_time":"2018-04-10T04:42:51.012Z","__v":0},{"user_id":360,"id":33,"user_name":"kkjh","avatar":"http://p3d0ne50u.bkt.clouddn.com/Fo0_vp5C4EThie4WBm9z9QMACC0A","restaurant_id":32,"restaurant":"5ac5af803714cc2d644f4615","comment_data":"损公肥私","order_id":656,"food_score":3,"delivery_score":5,"pic_url":["http://p3d0ne50u.bkt.clouddn.com/Fo0_vp5C4EThie4WBm9z9QMACC0A"],"add_comment_list":[],"comment_time":"2018-04-10T04:42:51.012Z","__v":0},{"user_id":483,"id":36,"user_name":"liuluwei","avatar":"http://i.waimai.meituan.com/static/img/default-avatar.png","restaurant_id":32,"restaurant":"5ac5af803714cc2d644f4615","comment_data":"好吃","order_id":716,"food_score":5,"delivery_score":5,"pic_url":[],"add_comment_list":[],"comment_time":"2018-04-10T04:42:51.012Z","__v":0}]
     */

    private int status;
    private String message;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_id : 227
         * id : 29
         * user_name : jjjjj
         * avatar : http://i.waimai.meituan.com/static/img/default-avatar.png
         * restaurant_id : 32
         * restaurant : 5ac5af803714cc2d644f4615
         * comment_data : 摸摸
         * order_id : 375
         * food_score : 4
         * delivery_score : 4
         * pic_url : ["http://p3d0ne50u.bkt.clouddn.com/FrmvnNe2aXy7iMKLMeuK1JxnDwXT"]
         * add_comment_list : []
         * comment_time : 2018-04-10T04:42:51.012Z
         * __v : 0
         */

        private int user_id;
        private int id;
        private String user_name;
        private String avatar;
        private int restaurant_id;
        private String restaurant;
        private String comment_data;
        private int order_id;
        private int food_score;
        private int delivery_score;
        private String comment_time;
        private int __v;
        private List<String> pic_url;
        private List<?> add_comment_list;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getRestaurant_id() {
            return restaurant_id;
        }

        public void setRestaurant_id(int restaurant_id) {
            this.restaurant_id = restaurant_id;
        }

        public String getRestaurant() {
            return restaurant;
        }

        public void setRestaurant(String restaurant) {
            this.restaurant = restaurant;
        }

        public String getComment_data() {
            return comment_data;
        }

        public void setComment_data(String comment_data) {
            this.comment_data = comment_data;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public int getFood_score() {
            return food_score;
        }

        public void setFood_score(int food_score) {
            this.food_score = food_score;
        }

        public int getDelivery_score() {
            return delivery_score;
        }

        public void setDelivery_score(int delivery_score) {
            this.delivery_score = delivery_score;
        }

        public String getComment_time() {
            return comment_time;
        }

        public void setComment_time(String comment_time) {
            this.comment_time = comment_time;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public List<String> getPic_url() {
            return pic_url;
        }

        public void setPic_url(List<String> pic_url) {
            this.pic_url = pic_url;
        }

        public List<?> getAdd_comment_list() {
            return add_comment_list;
        }

        public void setAdd_comment_list(List<?> add_comment_list) {
            this.add_comment_list = add_comment_list;
        }
    }
}
