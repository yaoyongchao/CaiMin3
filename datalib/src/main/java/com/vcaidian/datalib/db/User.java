package com.vcaidian.datalib.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Author: Austin
 * @Date: 2018/10/26
 * @Description:
 */
@Entity
public class User {

    /**
     * avatar_url : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIM6kVyKPUQLs8VjEQP1EsYq8lkKW08hJgVTib9g6eXqddRLK9pviau1wb46y1dpgqRiamGedxUj1fiag/132
     * c_id_1 : 689
     * c_id_2 : 56
     * concern : 1
     * file_id : 152
     * is_expert : 1
     * nickname : 宋璐悦
     * open_id : oMqGFwkjiJbX2HOQpmBGPN2xkFyU
     * reg_time : 1512036278
     * sex : 2
     * tel_phone : 18611326800
     * union_id : oWuRqs9skldC5566XVSn320FYilU
     * url : http://weixin.qq.com/q/023ErftrCJ9y_10000M03v
     * username : 18611326800
     * weixin_account_id : 18611326800
     * zfb_id :
     */
    @Id(autoincrement = true)
    private Long id;
    @Unique
    private long userId;
    private String avatar_url;
    private int c_id_1;
    private int c_id_2;
    private int concern;
    private int file_id;
    private int is_expert;
    private String nickname;
    private String open_id;
    private int reg_time;
    private int sex;
    private String tel_phone;
    private String union_id;
    private String url;
    private String username;
    private String weixin_account_id;
    private String zfb_id;



    @Generated(hash = 1840180232)
    public User(Long id, long userId, String avatar_url, int c_id_1, int c_id_2, int concern, int file_id, int is_expert, String nickname, String open_id,
            int reg_time, int sex, String tel_phone, String union_id, String url, String username, String weixin_account_id, String zfb_id) {
        this.id = id;
        this.userId = userId;
        this.avatar_url = avatar_url;
        this.c_id_1 = c_id_1;
        this.c_id_2 = c_id_2;
        this.concern = concern;
        this.file_id = file_id;
        this.is_expert = is_expert;
        this.nickname = nickname;
        this.open_id = open_id;
        this.reg_time = reg_time;
        this.sex = sex;
        this.tel_phone = tel_phone;
        this.union_id = union_id;
        this.url = url;
        this.username = username;
        this.weixin_account_id = weixin_account_id;
        this.zfb_id = zfb_id;
    }

    @Generated(hash = 586692638)
    public User() {
    }

   

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getC_id_1() {
        return c_id_1;
    }

    public void setC_id_1(int c_id_1) {
        this.c_id_1 = c_id_1;
    }

    public int getC_id_2() {
        return c_id_2;
    }

    public void setC_id_2(int c_id_2) {
        this.c_id_2 = c_id_2;
    }

    public int getConcern() {
        return concern;
    }

    public void setConcern(int concern) {
        this.concern = concern;
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public int getIs_expert() {
        return is_expert;
    }

    public void setIs_expert(int is_expert) {
        this.is_expert = is_expert;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public int getReg_time() {
        return reg_time;
    }

    public void setReg_time(int reg_time) {
        this.reg_time = reg_time;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getTel_phone() {
        return tel_phone;
    }

    public void setTel_phone(String tel_phone) {
        this.tel_phone = tel_phone;
    }

    public String getUnion_id() {
        return union_id;
    }

    public void setUnion_id(String union_id) {
        this.union_id = union_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getZfb_id() {
        return zfb_id;
    }

    public void setZfb_id(String zfb_id) {
        this.zfb_id = zfb_id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
