package application.hexindai.com.rxhexindai.manager;


/**
 * 标的状态管理
 * Created by zry on 2015/4/28.
 */
public class BidManage {
    /**
     * 提交
     */
    public final static int Submit = 1;
    /**
     * 请求发布
     */
    public final static int ReleaseTime = 2;
    /**
     * 准备中
     */
    public final static int Afoot = 3;

    //1提交2请求发布3准备中4预热中5保存6失败7满标8招标中10还款中11复审失败12发布失败13初审失败14用户取消15已还清
    /**
     * 预热中
     */
    public final static int Peheat = 4;
    /**
     * 保存
     */
    public final static int Save = 5;
    /**
     * 失败
     */
    public final static int Failure = 6;
    /**
     * 满标
     */
    public final static int FullBid = 7;
    /**
     * 招标中
     */
    public final static int Tender = 8;
    /**
     * 还款中
     */
    public final static int Repayment = 10;
    /**
     * 复审失败
     */
    public final static int ReviewFailure = 11;
    /**
     * 发布失败
     */
    public final static int ReleaseFailure = 12;
    /**
     * 初审失败
     */
    public final static int FirstTrialFailure = 13;
    /**
     * 用户取消
     */
    public final static int UserCancel = 14;
    /**
     * 用户取消
     */
    public final static int Yihuanqing = 15;
    /**
     * 荷包预热中.l
     */
    public final static int HebaoPeheat = 16;
    /**
     * 荷包招标中
     */
    public final static int HebaoTender = 20;
    /**
     * 荷包锁定中
     */
    public final static int HebaoSuodingzhong = 25;
    /**
     * 荷包收益中
     */
    public final static int HebaoShouyizhong = 30;
    /**
     * 计划满额
     */
    public final static int HebaoJihuamane = 21;
    /**
     * 已经结清
     */
    public final static int HebaoYijieqing = 35;

    /**
     * 抵押标
     */
    public static int DIYABIAO = 1;

    /**
     * 信用标
     */
    public static int XINYONGBIAO = 4;
    /**
     * 荷包
     */
    public static int HEBAO = 6;
    /**
     * 秒投
     */
    public static String MiaotouBid;
    public static float miaotoujine;

    /**
     * 判断是否是满标
     *
     * @param state
     * @return
     */
    public static boolean isFullbid(int state) {
        return state == BidManage.HebaoSuodingzhong || state == BidManage.HebaoShouyizhong || state == BidManage.HebaoJihuamane ||
                state == BidManage.HebaoYijieqing || state == BidManage.Yihuanqing || state == BidManage.FullBid ||
                state == BidManage.Repayment;
    }

    /**
     * 判断是否是招标中
     *
     * @param state
     * @return
     */
    public static boolean isTender(int state) {
        return state == BidManage.Tender || state == BidManage.HebaoTender;
    }

    /**
     * 判断是否是预热中
     *
     * @param state
     * @return
     */
    public static boolean isPeheat(int state) {
        return state == BidManage.Peheat || state == BidManage.HebaoPeheat;
    }

}
