package name.electricalqzhang.springbootlearn.model;

import java.util.List;

public class Example {
    /**
     * flowId : 141
     * flowParam : [{"orderId":"938400223","customerId":"xx","customerName":"xx","customerTel":"xx","ivcTitle":"xx","ivcType":"xx","ivcContent":"xx","ivcContentName":"","province":"北京","provinceNo":"xx","city":"","cityNo":"","county":"","countyNo":"xx","address":"","taxNo":"xx","regAccount":"xx","regAddress":"xx","regBank":"xx","regTel":"xx","taskExeStatus":"xx","taskExeResult":"","createTime":"xx","taskId":"xx"}]
     */

    private String flowId;
    private List<FlowParamBean> flowParam;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public List<FlowParamBean> getFlowParam() {
        return flowParam;
    }

    public void setFlowParam(List<FlowParamBean> flowParam) {
        this.flowParam = flowParam;
    }

    public static class FlowParamBean {
        /**
         * orderId : 938400223
         * customerId : xx
         * customerName : xx
         * customerTel : xx
         * ivcTitle : xx
         * ivcType : xx
         * ivcContent : xx
         * ivcContentName :
         * province : 北京
         * provinceNo : xx
         * city :
         * cityNo :
         * county :
         * countyNo : xx
         * address :
         * taxNo : xx
         * regAccount : xx
         * regAddress : xx
         * regBank : xx
         * regTel : xx
         * taskExeStatus : xx
         * taskExeResult :
         * createTime : xx
         * taskId : xx
         */

        private String orderId;
        private String customerId;
        private String customerName;
        private String customerTel;
        private String ivcTitle;
        private String ivcType;
        private String ivcContent;
        private String ivcContentName;
        private String province;
        private String provinceNo;
        private String city;
        private String cityNo;
        private String county;
        private String countyNo;
        private String address;
        private String taxNo;
        private String regAccount;
        private String regAddress;
        private String regBank;
        private String regTel;
        private String taskExeStatus;
        private String taskExeResult;
        private String createTime;
        private String taskId;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerTel() {
            return customerTel;
        }

        public void setCustomerTel(String customerTel) {
            this.customerTel = customerTel;
        }

        public String getIvcTitle() {
            return ivcTitle;
        }

        public void setIvcTitle(String ivcTitle) {
            this.ivcTitle = ivcTitle;
        }

        public String getIvcType() {
            return ivcType;
        }

        public void setIvcType(String ivcType) {
            this.ivcType = ivcType;
        }

        public String getIvcContent() {
            return ivcContent;
        }

        public void setIvcContent(String ivcContent) {
            this.ivcContent = ivcContent;
        }

        public String getIvcContentName() {
            return ivcContentName;
        }

        public void setIvcContentName(String ivcContentName) {
            this.ivcContentName = ivcContentName;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getProvinceNo() {
            return provinceNo;
        }

        public void setProvinceNo(String provinceNo) {
            this.provinceNo = provinceNo;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityNo() {
            return cityNo;
        }

        public void setCityNo(String cityNo) {
            this.cityNo = cityNo;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getCountyNo() {
            return countyNo;
        }

        public void setCountyNo(String countyNo) {
            this.countyNo = countyNo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTaxNo() {
            return taxNo;
        }

        public void setTaxNo(String taxNo) {
            this.taxNo = taxNo;
        }

        public String getRegAccount() {
            return regAccount;
        }

        public void setRegAccount(String regAccount) {
            this.regAccount = regAccount;
        }

        public String getRegAddress() {
            return regAddress;
        }

        public void setRegAddress(String regAddress) {
            this.regAddress = regAddress;
        }

        public String getRegBank() {
            return regBank;
        }

        public void setRegBank(String regBank) {
            this.regBank = regBank;
        }

        public String getRegTel() {
            return regTel;
        }

        public void setRegTel(String regTel) {
            this.regTel = regTel;
        }

        public String getTaskExeStatus() {
            return taskExeStatus;
        }

        public void setTaskExeStatus(String taskExeStatus) {
            this.taskExeStatus = taskExeStatus;
        }

        public String getTaskExeResult() {
            return taskExeResult;
        }

        public void setTaskExeResult(String taskExeResult) {
            this.taskExeResult = taskExeResult;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }
    }
}
