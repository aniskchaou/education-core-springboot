package com.dev.delta.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	String topicTitle;
	String courseRequirements;
	String courseDescription;
	@ManyToOne
	Category category;
	String level;
	String language;
	String duration;
	String thumbnail;
	String isfree;
	String price;
	String discount;
	String featuredCourse;
	String previewVideo;
	String coverImage;
	String capacity;
	String startDate;
	String downloadable;
	String partnerInstructor;

	String teacher;

	@ManyToOne
	Section section;

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public String getCourseRequirements() {
		return courseRequirements;
	}

	public void setCourseRequirements(String courseRequirements) {
		this.courseRequirements = courseRequirements;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getIsfree() {
		return isfree;
	}

	public void setIsfree(String isfree) {
		this.isfree = isfree;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getFeaturedCourse() {
		return featuredCourse;
	}

	public void setFeaturedCourse(String featuredCourse) {
		this.featuredCourse = featuredCourse;
	}

	public String getPreviewVideo() {
		return previewVideo;
	}

	public void setPreviewVideo(String previewVideo) {
		this.previewVideo = previewVideo;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDownloadable() {
		return downloadable;
	}

	public void setDownloadable(String downloadable) {
		this.downloadable = downloadable;
	}

	public String getPartnerInstructor() {
		return partnerInstructor;
	}

	public void setPartnerInstructor(String partnerInstructor) {
		this.partnerInstructor = partnerInstructor;
	}
	
	

}
