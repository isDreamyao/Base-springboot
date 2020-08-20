package com.example.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-08-14 15:57
 * @description
 */
@Alias("oilStation")
@Data
public class OilStationEntity {

    /**
     *
     */
    private Long id;
    /**
     * 业务主键
     */
    private Long stationId;
    /**
     * 油站来源 1-自营 2-山东高速 3-中国石油 4-找油网 5-宝兑通 6-壳牌
     */
    private Integer stationSource;
    /**
     * 油站类型 0:默认 1：A站（非高速站） 2：B站（高速站）
     */
    private Integer stationType;
    /**
     * 商户ID
     */
    private Long merchantId;
    /**
     * 商户名称
     */
    private String merchantName;
    /**
     * 油站唯一编号
     */
    private String stationCode;
    /**
     * 油站名称
     */
    private String stationName;
    /**
     * 油站地址省
     */
    private String stationProvince;
    /**
     * 油站地址市
     */
    private String stationCity;
    /**
     * 油站地址区
     */
    private String stationDistrict;
    /**
     * 油站详细地址
     */
    private String stationSpace;
    /**
     * 油站联系方式
     */
    private String stationMobile;
    /**
     * 油站头图
     */
    private String stationHeadpic;
    /**
     * 油站经度
     */
    private Double stationLng;
    /**
     * 油站纬度
     */
    private Double stationLat;
    /**
     * 油站经度【高德地图】
     */
    private Double stationLngAmap;
    /**
     * 油站纬度【高德地图】
     */
    private Double stationLatAmap;
    /**
     * 折扣比例
     */
    private Integer discountPercent;
    /**
     * 增值服务
     */
    private String moreService;
    /**
     * 对接人
     */
    private String relUser;
    /**
     * 对接人手机号
     */
    private String relMobile;
    /**
     * 油站对接人
     */
    private String oilrelUser;
    /**
     * 油站对接人手机号
     */
    private String oilrelMobile;
    /**
     * 第三方油站ID
     */
    private String trdStationId;
    /**
     * GeoHash地理编码
     */
    private String geoHashStr;
    /**
     * 油站状态 1-正常 2-冻结
     */
    private Integer oilState;
    /**
     * 冻结/解冻原因
     */
    private String cause;
    /**
     * 是否管理油站 1-是 0-否
     */
    private Integer manageFlag;
    /**
     * 创建人ID
     */
    private Long createdBy;
    /**
     * 创建人名称
     */
    private String createdByName;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改人ID
     */
    private Long lastUptBy;
    /**
     * 修改人名称
     */
    private String lastUptByName;
    /**
     * 修改时间
     */
    private Date lastUptTime;
    /**
     * 数据版本号
     */
    private Integer version;
    /**
     * 删除状态 0-正常 1-删除
     */
    private Integer deleteFlag;
    /**
     * 二维码数据
     */
    private String qrcode;

}


