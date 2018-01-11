package com.skywalker.idouban.models.movie;

import com.skywalker.idouban.models.Images;
import com.skywalker.idouban.models.Rating;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/9               *
 *******************************/

public class Movie {

    private Rating rating;
    private long reviews_count;
    private long wish_count;
    private String douban_site;
    private String year;
    private Images images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private String do_count;
    private String share_url;
    private String seasons_count;
    private String schedule_url;
    private String episodes_count;
    private String[] countries;
    private String[] genres;
    private int collect_count;
    private Casts[] casts;
    private int current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private Casts[] directors;
    private int comments_count;
    private int ratings_count;
    private String[] aka;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public long getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(long reviews_count) {
        this.reviews_count = reviews_count;
    }

    public long getWish_count() {
        return wish_count;
    }

    public void setWish_count(long wish_count) {
        this.wish_count = wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDo_count() {
        return do_count;
    }

    public void setDo_count(String do_count) {
        this.do_count = do_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(String seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public String getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(String episodes_count) {
        this.episodes_count = episodes_count;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public Casts[] getCasts() {
        return casts;
    }

    public void setCasts(Casts[] casts) {
        this.casts = casts;
    }

    public int getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(int current_season) {
        this.current_season = current_season;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public Casts[] getDirectors() {
        return directors;
    }

    public void setDirectors(Casts[] directors) {
        this.directors = directors;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public String[] getAka() {
        return aka;
    }

    public void setAka(String[] aka) {
        this.aka = aka;
    }


}
