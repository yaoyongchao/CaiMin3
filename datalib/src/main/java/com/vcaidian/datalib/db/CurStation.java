package com.vcaidian.datalib.db;

import com.vcaidian.datalib.bean.GamesBean;

/**
 * @Author: Austin
 * @Date: 10/25/18
 * @Description:　当前店铺信息
　 */
//@Entity
public class CurStation {

    /**
     * addr : 北京市通州区543乡道
     * ahead_end_time : 180
     * card_no : 哎呦呦
     * descrip : 哈哈哈
     * face_pic_id : 170
     * games : {"200":1,"201":1,"202":1,"203":1,"205":1,"207":1,"301":1,"401":1,"402":1,"403":1,"404":1,"602":1}
     * id : 689
     * is_info_open : 1
     * is_online_recharge : 1
     * lantitude : 39.76863098144531
     * longitude : 116.58798980712889
     * name : 哎呀呀
     * nickname : 2398790178732
     * notice : 店内信息公告，接到微信渠道通知，在线支付渠道暂时关闭，恢复时间另行通知，期间彩民充值暂时通过线下转账完成，直接转微信或支付宝，谢谢。
     * paper_status : 20
     * permit_cash_least : 4000
     * sale_pic_id : 168
     * sale_status : 0
     * scheme_avg_amount : 200
     * self_c_id : 56
     * tel_phone : 18611326800
     * username : 18611326800
     * weixin_account_id : 141242141
     * weixin_account_pic_id : -1
     * weixin_account_url : http://u.wechat.com/EG5dBJakKN5fLlqbj09-U5Q
     * weixin_rec_url : http://www.chinayunshang.com/portal/down/xdbao/0032002C3335511738303537
     * zfb_id : 4214214214
     */
    private Long id;
    private String addr;
    private int ahead_end_time;
    private String card_no;
    private String descrip;
    private int face_pic_id;
    private GamesBean games;
    private int is_info_open;
    private int is_online_recharge;
    private double lantitude;
    private double longitude;
    private String name;
    private String nickname;
    private String notice;
    private int paper_status;
    private int permit_cash_least;
    private int sale_pic_id;
    private int sale_status;
    private int scheme_avg_amount;
    private int self_c_id;
    private String tel_phone;
    private String username;
    private String weixin_account_id;
    private int weixin_account_pic_id;
    private String weixin_account_url;
    private String weixin_rec_url;
    private String zfb_id;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getAhead_end_time() {
        return ahead_end_time;
    }

    public void setAhead_end_time(int ahead_end_time) {
        this.ahead_end_time = ahead_end_time;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getFace_pic_id() {
        return face_pic_id;
    }

    public void setFace_pic_id(int face_pic_id) {
        this.face_pic_id = face_pic_id;
    }

    public GamesBean getGames() {
        return games;
    }

    public void setGames(GamesBean games) {
        this.games = games;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIs_info_open() {
        return is_info_open;
    }

    public void setIs_info_open(int is_info_open) {
        this.is_info_open = is_info_open;
    }

    public int getIs_online_recharge() {
        return is_online_recharge;
    }

    public void setIs_online_recharge(int is_online_recharge) {
        this.is_online_recharge = is_online_recharge;
    }

    public double getLantitude() {
        return lantitude;
    }

    public void setLantitude(double lantitude) {
        this.lantitude = lantitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public int getPaper_status() {
        return paper_status;
    }

    public void setPaper_status(int paper_status) {
        this.paper_status = paper_status;
    }

    public int getPermit_cash_least() {
        return permit_cash_least;
    }

    public void setPermit_cash_least(int permit_cash_least) {
        this.permit_cash_least = permit_cash_least;
    }

    public int getSale_pic_id() {
        return sale_pic_id;
    }

    public void setSale_pic_id(int sale_pic_id) {
        this.sale_pic_id = sale_pic_id;
    }

    public int getSale_status() {
        return sale_status;
    }

    public void setSale_status(int sale_status) {
        this.sale_status = sale_status;
    }

    public int getScheme_avg_amount() {
        return scheme_avg_amount;
    }

    public void setScheme_avg_amount(int scheme_avg_amount) {
        this.scheme_avg_amount = scheme_avg_amount;
    }

    public int getSelf_c_id() {
        return self_c_id;
    }

    public void setSelf_c_id(int self_c_id) {
        this.self_c_id = self_c_id;
    }

    public String getTel_phone() {
        return tel_phone;
    }

    public void setTel_phone(String tel_phone) {
        this.tel_phone = tel_phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWeixin_account_id() {
        return weixin_account_id;
    }

    public void setWeixin_account_id(String weixin_account_id) {
        this.weixin_account_id = weixin_account_id;
    }

    public int getWeixin_account_pic_id() {
        return weixin_account_pic_id;
    }

    public void setWeixin_account_pic_id(int weixin_account_pic_id) {
        this.weixin_account_pic_id = weixin_account_pic_id;
    }

    public String getWeixin_account_url() {
        return weixin_account_url;
    }

    public void setWeixin_account_url(String weixin_account_url) {
        this.weixin_account_url = weixin_account_url;
    }

    public String getWeixin_rec_url() {
        return weixin_rec_url;
    }

    public void setWeixin_rec_url(String weixin_rec_url) {
        this.weixin_rec_url = weixin_rec_url;
    }

    public String getZfb_id() {
        return zfb_id;
    }

    public void setZfb_id(String zfb_id) {
        this.zfb_id = zfb_id;
    }


}
