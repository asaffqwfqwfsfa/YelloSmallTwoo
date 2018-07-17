package com.example.john.yellosmalltwo.bean;

import java.util.List;

/**
 * Created by john on 2018/6/25.
 */

public class RestaurantBean {

    /**
     * status : 1
     * message : 获取指定餐馆信息成功
     * data : {"id":32,"name":"麦当当的店","month_sales":194,"month_sales_tip":"月售194笔","wm_poi_score":3,"delivery_score":2.1,"quality_score":3.7,"pack_score":4.1,"food_score":1.1,"delivery_time_tip":"50分钟","third_category":"中式简餐","pic_url":"http://p0.meituan.net/xianfu/fdd295e7650587269e0f1d7c35ba180c114177.jpg","shopping_time_start":"8:00","shopping_time_end":"24:00","min_price":10,"min_price_tip":"起送 ￥10","shipping_fee":0,"shipping_fee_tip":"配送 ￥0","bulletin":"理工短号615592（原大学生粗粮坊）做你身边最快的外卖！","address":"东莞市大岭山镇元岭村翠园街7巷20号102铺","call_center":"15916985301","distance":"","average_price_tip":"人均20","comment_number":53,"lng":"113.854074","lat":"22.901119","created_at":"2018-04-05T05:08:44.533Z","discounts2":[{"info":"满20减18;满45减40;满60减53","icon_url":"http://p0.meituan.net/xianfu/f8bc8dffdbc805878aa3801a33f563cd1001.png","promotion_type":2},{"info":"折扣商品7.33折起","icon_url":"http://p1.meituan.net/xianfu/9c997ecce6150671b8459738a26f8bd9767.png","promotion_type":2},{"info":"新用户立减2元,首次使用银行卡支付最高再减3元","icon_url":"http://p0.meituan.net/xianfu/019d1bbb1310b1531e6af6172c9a5095581.png","promotion_type":2}],"__v":0}
     */

    private int status;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 32
         * name : 麦当当的店
         * month_sales : 194
         * month_sales_tip : 月售194笔
         * wm_poi_score : 3
         * delivery_score : 2.1
         * quality_score : 3.7
         * pack_score : 4.1
         * food_score : 1.1
         * delivery_time_tip : 50分钟
         * third_category : 中式简餐
         * pic_url : http://p0.meituan.net/xianfu/fdd295e7650587269e0f1d7c35ba180c114177.jpg
         * shopping_time_start : 8:00
         * shopping_time_end : 24:00
         * min_price : 10
         * min_price_tip : 起送 ￥10
         * shipping_fee : 0
         * shipping_fee_tip : 配送 ￥0
         * bulletin : 理工短号615592（原大学生粗粮坊）做你身边最快的外卖！
         * address : 东莞市大岭山镇元岭村翠园街7巷20号102铺
         * call_center : 15916985301
         * distance :
         * average_price_tip : 人均20
         * comment_number : 53
         * lng : 113.854074
         * lat : 22.901119
         * created_at : 2018-04-05T05:08:44.533Z
         * discounts2 : [{"info":"满20减18;满45减40;满60减53","icon_url":"http://p0.meituan.net/xianfu/f8bc8dffdbc805878aa3801a33f563cd1001.png","promotion_type":2},{"info":"折扣商品7.33折起","icon_url":"http://p1.meituan.net/xianfu/9c997ecce6150671b8459738a26f8bd9767.png","promotion_type":2},{"info":"新用户立减2元,首次使用银行卡支付最高再减3元","icon_url":"http://p0.meituan.net/xianfu/019d1bbb1310b1531e6af6172c9a5095581.png","promotion_type":2}]
         * __v : 0
         */

        private int id;
        private String name;
        private int month_sales;
        private String month_sales_tip;
        private int wm_poi_score;
        private double delivery_score;
        private double quality_score;
        private double pack_score;
        private double food_score;
        private String delivery_time_tip;
        private String third_category;
        private String pic_url;
        private String shopping_time_start;
        private String shopping_time_end;
        private int min_price;
        private String min_price_tip;
        private int shipping_fee;
        private String shipping_fee_tip;
        private String bulletin;
        private String address;
        private String call_center;
        private String distance;
        private String average_price_tip;
        private int comment_number;
        private String lng;
        private String lat;
        private String created_at;
        private int __v;
        private List<Discounts2Bean> discounts2;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMonth_sales() {
            return month_sales;
        }

        public void setMonth_sales(int month_sales) {
            this.month_sales = month_sales;
        }

        public String getMonth_sales_tip() {
            return month_sales_tip;
        }

        public void setMonth_sales_tip(String month_sales_tip) {
            this.month_sales_tip = month_sales_tip;
        }

        public int getWm_poi_score() {
            return wm_poi_score;
        }

        public void setWm_poi_score(int wm_poi_score) {
            this.wm_poi_score = wm_poi_score;
        }

        public double getDelivery_score() {
            return delivery_score;
        }

        public void setDelivery_score(double delivery_score) {
            this.delivery_score = delivery_score;
        }

        public double getQuality_score() {
            return quality_score;
        }

        public void setQuality_score(double quality_score) {
            this.quality_score = quality_score;
        }

        public double getPack_score() {
            return pack_score;
        }

        public void setPack_score(double pack_score) {
            this.pack_score = pack_score;
        }

        public double getFood_score() {
            return food_score;
        }

        public void setFood_score(double food_score) {
            this.food_score = food_score;
        }

        public String getDelivery_time_tip() {
            return delivery_time_tip;
        }

        public void setDelivery_time_tip(String delivery_time_tip) {
            this.delivery_time_tip = delivery_time_tip;
        }

        public String getThird_category() {
            return third_category;
        }

        public void setThird_category(String third_category) {
            this.third_category = third_category;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getShopping_time_start() {
            return shopping_time_start;
        }

        public void setShopping_time_start(String shopping_time_start) {
            this.shopping_time_start = shopping_time_start;
        }

        public String getShopping_time_end() {
            return shopping_time_end;
        }

        public void setShopping_time_end(String shopping_time_end) {
            this.shopping_time_end = shopping_time_end;
        }

        public int getMin_price() {
            return min_price;
        }

        public void setMin_price(int min_price) {
            this.min_price = min_price;
        }

        public String getMin_price_tip() {
            return min_price_tip;
        }

        public void setMin_price_tip(String min_price_tip) {
            this.min_price_tip = min_price_tip;
        }

        public int getShipping_fee() {
            return shipping_fee;
        }

        public void setShipping_fee(int shipping_fee) {
            this.shipping_fee = shipping_fee;
        }

        public String getShipping_fee_tip() {
            return shipping_fee_tip;
        }

        public void setShipping_fee_tip(String shipping_fee_tip) {
            this.shipping_fee_tip = shipping_fee_tip;
        }

        public String getBulletin() {
            return bulletin;
        }

        public void setBulletin(String bulletin) {
            this.bulletin = bulletin;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCall_center() {
            return call_center;
        }

        public void setCall_center(String call_center) {
            this.call_center = call_center;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getAverage_price_tip() {
            return average_price_tip;
        }

        public void setAverage_price_tip(String average_price_tip) {
            this.average_price_tip = average_price_tip;
        }

        public int getComment_number() {
            return comment_number;
        }

        public void setComment_number(int comment_number) {
            this.comment_number = comment_number;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public List<Discounts2Bean> getDiscounts2() {
            return discounts2;
        }

        public void setDiscounts2(List<Discounts2Bean> discounts2) {
            this.discounts2 = discounts2;
        }

        public static class Discounts2Bean {
            /**
             * info : 满20减18;满45减40;满60减53
             * icon_url : http://p0.meituan.net/xianfu/f8bc8dffdbc805878aa3801a33f563cd1001.png
             * promotion_type : 2
             */

            private String info;
            private String icon_url;
            private int promotion_type;

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }

            public int getPromotion_type() {
                return promotion_type;
            }

            public void setPromotion_type(int promotion_type) {
                this.promotion_type = promotion_type;
            }
        }
    }
}
