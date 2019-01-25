package com.example.hp.onlineshopping.Model.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetHome {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("data")
    @Expose
    private HomeData HomeData;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HomeData getHomeData() {
        return HomeData;
    }

    public void setHomeData(HomeData homeData) {
        HomeData = homeData;
    }

 public class HomeData {
        @SerializedName("up_banner")
        @Expose
        private List<Banner> upBanner ;
        @SerializedName("down_banner")
        @Expose
        private Banner downBanner;
        @SerializedName("hot")
        @Expose
        private List<Product> hot ;
        @SerializedName("flash")
        @Expose
        private List<Product> flash = null;
        @SerializedName("newest")
        @Expose
        private List<Product> newest = null;


        public List<Banner> getUpBanner() {
            return upBanner;
        }

        public void setUpBanner(List<Banner> upBanner) {
            this.upBanner = upBanner;
        }

        public Banner getDownBanner() {
            return downBanner;
        }

        public void setDownBanner(Banner downBanner) {
            this.downBanner = downBanner;
        }

        public List<Product> getHot() {
            return hot;
        }

        public void setHot(List<Product> hot) {
            this.hot = hot;
        }

        public List<Product> getFlash() {
            return flash;
        }

        public void setFlash(List<Product> flash) {
            this.flash = flash;
        }

        public List<Product> getNewest() {
            return newest;
        }

        public void setNewest(List<Product> newest) {
            this.newest = newest;
        }
    }

    public  class Banner {
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("image")
        @Expose
        private String image;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public class Product {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("end_date")
        @Expose
        private String endDate;
        @SerializedName("price_before")
        @Expose
        private String priceBefore;
        @SerializedName("price_after")
        @Expose
        private String priceAfter;
        @SerializedName("image")
        @Expose
        private String image;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getPriceBefore() {
            return priceBefore;
        }

        public void setPriceBefore(String priceBefore) {
            this.priceBefore = priceBefore;
        }

        public String getPriceAfter() {
            return priceAfter;
        }

        public void setPriceAfter(String priceAfter) {
            this.priceAfter = priceAfter;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}