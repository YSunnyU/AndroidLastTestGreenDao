package com.sunny.androidlasttestgreendao.bean;

import java.util.List;

/**
 * Created by 张玗 on 2018/3/27.
 */

public class NewsMess {
    /**
     * message : 请求成功
     * code : 200
     * result : [{"pic":"http://img2.imgtn.bdimg.com/it/u=1099905226,1865989804&fm=11&gp=0.jpg"},{"pic":"http://img0.imgtn.bdimg.com/it/u=2000421042,3877694770&fm=11&gp=0.jpg"},{"pic":"http://img0.imgtn.bdimg.com/it/u=2060095744,4097622156&fm=11&gp=0.jpg"},{"pic":"http://img2.imgtn.bdimg.com/it/u=1354849427,261341415&fm=27&gp=0.jpg"},{"pic":"http://img4.imgtn.bdimg.com/it/u=1420958888,769383764&fm=27&gp=0.jpg"},{"pic":"http://img4.imgtn.bdimg.com/it/u=1404785160,1779522610&fm=27&gp=0.jpg"},{"pic":"http://img0.imgtn.bdimg.com/it/u=1770117331,4173731409&fm=27&gp=0.jpg"},{"pic":"http://img0.imgtn.bdimg.com/it/u=3111863248,4006579962&fm=27&gp=0.jpg"},{"pic":"http://img5.imgtn.bdimg.com/it/u=463274617,209809588&fm=27&gp=0.jpg"},{"pic":"http://img3.imgtn.bdimg.com/it/u=3842309048,726988343&fm=27&gp=0.jpg"},{"pic":"http://img5.imgtn.bdimg.com/it/u=240658530,263639831&fm=27&gp=0.jpg"},{"pic":"http://img5.imgtn.bdimg.com/it/u=2443193327,2070503668&fm=27&gp=0.jpg"},{"pic":"http://img4.imgtn.bdimg.com/it/u=132141105,64538077&fm=27&gp=0.jpg"},{"pic":"http://img2.imgtn.bdimg.com/it/u=4238562307,260872103&fm=27&gp=0.jpg"},{"pic":"http://img4.imgtn.bdimg.com/it/u=1165470528,3392233394&fm=27&gp=0.jpg"}]
     */

    private String message;
    private int code;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * pic : http://img2.imgtn.bdimg.com/it/u=1099905226,1865989804&fm=11&gp=0.jpg
         */

        private String pic;

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
