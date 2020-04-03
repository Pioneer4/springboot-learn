package name.electricalqzhang.springbootlearn.model;

import java.util.List;

public class NfObject {

    /**
     * code : 10000
     * charge : true
     * remain : 986
     * remainTimes : 986
     * remainSeconds : -1
     * msg : 查询成功,扣费
     * result : {"status":"ok","data":{"msg":"ok","phrases":["无人货柜","政务成本","全市杂粮","经济产业园","优质初创","孵化重点项目","鲜葵花","配送机器人","降低政务","助力经济","大数据","助力大同市","经济快车道","带来效益","大同市能源","构建全国","区域公用","数据平台","初创企业","数据基础设施","数字经济","互联网经济","智能无人","老字号企业","大同好粮","数据步入","提高政务","地方龙头企业","产业链落户","集聚电商","京东云","黄花智能","智能产品","电商产业","从事农业","智能物流","农业电商","亮小米","步入数字","公用品牌","智能农场","推动全市","农村电商","等为一体","示范基地","杂粮企业"]}}
     */

    private String code;
    private boolean charge;
    private int remain;
    private int remainTimes;
    private int remainSeconds;
    private String msg;
    private ResultBean result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public int getRemainTimes() {
        return remainTimes;
    }

    public void setRemainTimes(int remainTimes) {
        this.remainTimes = remainTimes;
    }

    public int getRemainSeconds() {
        return remainSeconds;
    }

    public void setRemainSeconds(int remainSeconds) {
        this.remainSeconds = remainSeconds;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * status : ok
         * data : {"msg":"ok","phrases":["无人货柜","政务成本","全市杂粮","经济产业园","优质初创","孵化重点项目","鲜葵花","配送机器人","降低政务","助力经济","大数据","助力大同市","经济快车道","带来效益","大同市能源","构建全国","区域公用","数据平台","初创企业","数据基础设施","数字经济","互联网经济","智能无人","老字号企业","大同好粮","数据步入","提高政务","地方龙头企业","产业链落户","集聚电商","京东云","黄花智能","智能产品","电商产业","从事农业","智能物流","农业电商","亮小米","步入数字","公用品牌","智能农场","推动全市","农村电商","等为一体","示范基地","杂粮企业"]}
         */

        private String status;
        private DataBean data;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * msg : ok
             * phrases : ["无人货柜","政务成本","全市杂粮","经济产业园","优质初创","孵化重点项目","鲜葵花","配送机器人","降低政务","助力经济","大数据","助力大同市","经济快车道","带来效益","大同市能源","构建全国","区域公用","数据平台","初创企业","数据基础设施","数字经济","互联网经济","智能无人","老字号企业","大同好粮","数据步入","提高政务","地方龙头企业","产业链落户","集聚电商","京东云","黄花智能","智能产品","电商产业","从事农业","智能物流","农业电商","亮小米","步入数字","公用品牌","智能农场","推动全市","农村电商","等为一体","示范基地","杂粮企业"]
             */

            private String msg;
            private List<String> phrases;

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public List<String> getPhrases() {
                return phrases;
            }

            public void setPhrases(List<String> phrases) {
                this.phrases = phrases;
            }
        }
    }
}

