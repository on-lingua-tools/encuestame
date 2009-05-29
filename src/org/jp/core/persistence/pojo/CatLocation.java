package org.jp.core.persistence.pojo;

// Generated 07-may-2009 17:38:33 by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

/**
 * CatLocation generated by hbm2java
 */
public class CatLocation implements java.io.Serializable {

	private int tid;
	private CatLocationType catLocationType;
	private CatState catState;
	private String description;
	private int level;
	private String active;
	private Integer govId;
	private Float lat;
	private Float lng;
	private String topographySheet;
	private Set<SurveyQuestionDependency> surveyQuestionDependencies = new HashSet<SurveyQuestionDependency>(
			0);
	private Set<ProjectLocation> proyectLocations = new HashSet<ProjectLocation>(
			0);
	private Set<SurveyLocation> surveyLocations = new HashSet<SurveyLocation>(0);
	private Set<SurveyType> surveyTypes = new HashSet<SurveyType>(0);
	private Set<CatLocationUser> catLocationUsers = new HashSet<CatLocationUser>(
			0);
	private Set<Surveys> surveyses = new HashSet<Surveys>(0);
	private Set<SurveySection> surveySections = new HashSet<SurveySection>(0);

	public CatLocation() {
	}

	public CatLocation(int tid, CatLocationType catLocationType,
			CatState catState, String description, int level, String active) {
		this.tid = tid;
		this.catLocationType = catLocationType;
		this.catState = catState;
		this.description = description;
		this.level = level;
		this.active = active;
	}

	public CatLocation(int tid, CatLocationType catLocationType,
			CatState catState, String description, int level, String active,
			Integer govId, Float lat, Float lng, String topographySheet,
			Set<SurveyQuestionDependency> surveyQuestionDependencies,
			Set<ProjectLocation> proyectLocations,
			Set<SurveyLocation> surveyLocations, Set<SurveyType> surveyTypes,
			Set<CatLocationUser> catLocationUsers, Set<Surveys> surveyses,
			Set<SurveySection> surveySections) {
		this.tid = tid;
		this.catLocationType = catLocationType;
		this.catState = catState;
		this.description = description;
		this.level = level;
		this.active = active;
		this.govId = govId;
		this.lat = lat;
		this.lng = lng;
		this.topographySheet = topographySheet;
		this.surveyQuestionDependencies = surveyQuestionDependencies;
		this.proyectLocations = proyectLocations;
		this.surveyLocations = surveyLocations;
		this.surveyTypes = surveyTypes;
		this.catLocationUsers = catLocationUsers;
		this.surveyses = surveyses;
		this.surveySections = surveySections;
	}

	public int getTid() {
		return this.tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public CatLocationType getCatLocationType() {
		return this.catLocationType;
	}

	public void setCatLocationType(CatLocationType catLocationType) {
		this.catLocationType = catLocationType;
	}

	public CatState getCatState() {
		return this.catState;
	}

	public void setCatState(CatState catState) {
		this.catState = catState;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Integer getGovId() {
		return this.govId;
	}

	public void setGovId(Integer govId) {
		this.govId = govId;
	}

	public Float getLat() {
		return this.lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLng() {
		return this.lng;
	}

	public void setLng(Float lng) {
		this.lng = lng;
	}

	public String getTopographySheet() {
		return this.topographySheet;
	}

	public void setTopographySheet(String topographySheet) {
		this.topographySheet = topographySheet;
	}

	public Set<SurveyQuestionDependency> getSurveyQuestionDependencies() {
		return this.surveyQuestionDependencies;
	}

	public void setSurveyQuestionDependencies(
			Set<SurveyQuestionDependency> surveyQuestionDependencies) {
		this.surveyQuestionDependencies = surveyQuestionDependencies;
	}

	public Set<ProjectLocation> getProyectLocations() {
		return this.proyectLocations;
	}

	public void setProyectLocations(Set<ProjectLocation> proyectLocations) {
		this.proyectLocations = proyectLocations;
	}

	public Set<SurveyLocation> getSurveyLocations() {
		return this.surveyLocations;
	}

	public void setSurveyLocations(Set<SurveyLocation> surveyLocations) {
		this.surveyLocations = surveyLocations;
	}

	public Set<SurveyType> getSurveyTypes() {
		return this.surveyTypes;
	}

	public void setSurveyTypes(Set<SurveyType> surveyTypes) {
		this.surveyTypes = surveyTypes;
	}

	public Set<CatLocationUser> getCatLocationUsers() {
		return this.catLocationUsers;
	}

	public void setCatLocationUsers(Set<CatLocationUser> catLocationUsers) {
		this.catLocationUsers = catLocationUsers;
	}

	public Set<Surveys> getSurveyses() {
		return this.surveyses;
	}

	public void setSurveyses(Set<Surveys> surveyses) {
		this.surveyses = surveyses;
	}

	public Set<SurveySection> getSurveySections() {
		return this.surveySections;
	}

	public void setSurveySections(Set<SurveySection> surveySections) {
		this.surveySections = surveySections;
	}

}
