package application.hexindai.com.rxhexindai.modular.homepage;

import java.util.List;

public class SumNotFillInfo {
    private static final long serialVersionUID = 1L;

    /**
     * ret_code : 0
     * ret_msg :
     * data : {"list":[{"bid_id":"10702516","bid_name":"ruiyu","bid_effect_real_ts":"2016-03-30 14:07:30","bid_end_ts":"2016-04-01 14:07:30","bid_money":"5","bid_money_exact":"50000.00","bid_complete_money":"0.00","state":"8","bid_type":"4","is_novice":"1","bid_rate":"11","bid_reward":"0","bid_duration":"3","bid_repayment_type":"按月还款等额本息","investfulltime":"0","bid_money_min":"50","bid_money_max":"0","is_plus_rate":"0","bid_plus_rate":"0","group":"0"},{"bid_id":"82","bid_name":"测试券荷包","bid_effect_real_ts":"2016-03-04 15:29:18","bid_end_ts":"2016-03-05 15:25:44","bid_money":"1","bid_money_exact":"10000.00","bid_complete_money":"9500","state":"21","bid_type":"6","is_novice":"0","bid_rate":"15","bid_reward":"0","bid_duration":"6","bid_repayment_type":"一次性还款","investfulltime":"0","bid_money_min":"100","bid_money_max":"10000","jindu_expectEndTime":"2016-03-05 15:25:44","endTime":null,"group":"0"},{"bid_id":"85","bid_name":"测试过期券荷包","bid_effect_real_ts":"2016-03-14 17:10:20","bid_end_ts":"2016-03-15 17:05:52","bid_money":"100","bid_money_exact":"1000000.00","bid_complete_money":"300000","state":"21","bid_type":"6","is_novice":"0","bid_rate":"10","bid_reward":"0","bid_duration":"6","bid_repayment_type":"一次性还款","investfulltime":"0","bid_money_min":"100","bid_money_max":"1000000","jindu_expectEndTime":"2016-03-15 17:05:52","endTime":null,"group":"0"},{"bid_id":"10702507","bid_name":"西永","bid_effect_real_ts":"2016-03-30 14:07:18","bid_end_ts":"2016-04-06 14:07:18","bid_money":"100","bid_money_exact":"1000000.00","bid_complete_money":"0.00","state":"8","bid_type":"1","is_novice":"0","bid_rate":"11","bid_reward":"5","bid_duration":"3","bid_repayment_type":"每月还息到期还本","investfulltime":"0","bid_money_min":"50","bid_money_max":"0","is_plus_rate":"1","bid_plus_rate":"5","group":"0"}]}
     */

    public int ret_code;
    public String ret_msg;
    public DataBean data;

    public static class DataBean {
        /**
         * bid_id : 10702516
         * bid_name : ruiyu
         * bid_effect_real_ts : 2016-03-30 14:07:30
         * bid_end_ts : 2016-04-01 14:07:30
         * bid_money : 5
         * bid_money_exact : 50000.00
         * bid_complete_money : 0.00
         * state : 8
         * bid_type : 4
         * is_novice : 1
         * bid_rate : 11
         * bid_reward : 0
         * bid_duration : 3
         * bid_repayment_type : 按月还款等额本息
         * investfulltime : 0
         * bid_money_min : 50
         * bid_money_max : 0
         * is_plus_rate : 0
         * bid_plus_rate : 0
         * group : 0
         */

        public List<ListBean> list;

        public static class ListBean {
            public String bid_id;
            public String bid_name;
            public String bid_effect_real_ts;
            public String bid_end_ts;
            public String bid_money;
            public String bid_money_exact;
            public String bid_complete_money;
            public int state;
            public int bid_type;
            public int is_novice;
            public String bid_rate;
            public String bid_reward;
            public String bid_duration;
            public String bid_repayment_type;
            public String investfulltime;
            public String bid_money_min;
            public String bid_money_max;
            public String is_plus_rate;
            public String bid_plus_rate;
            public String group;
        }
    }
}
