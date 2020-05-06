package org.bigdatahealth.findu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnouncementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnnouncementExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProIdIsNull() {
            addCriterion("pro_id is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(Long value) {
            addCriterion("pro_id =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(Long value) {
            addCriterion("pro_id <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(Long value) {
            addCriterion("pro_id >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pro_id >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(Long value) {
            addCriterion("pro_id <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(Long value) {
            addCriterion("pro_id <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<Long> values) {
            addCriterion("pro_id in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<Long> values) {
            addCriterion("pro_id not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(Long value1, Long value2) {
            addCriterion("pro_id between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(Long value1, Long value2) {
            addCriterion("pro_id not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProProfileIsNull() {
            addCriterion("pro_profile is null");
            return (Criteria) this;
        }

        public Criteria andProProfileIsNotNull() {
            addCriterion("pro_profile is not null");
            return (Criteria) this;
        }

        public Criteria andProProfileEqualTo(String value) {
            addCriterion("pro_profile =", value, "proProfile");
            return (Criteria) this;
        }

        public Criteria andProProfileNotEqualTo(String value) {
            addCriterion("pro_profile <>", value, "proProfile");
            return (Criteria) this;
        }

        public Criteria andProProfileGreaterThan(String value) {
            addCriterion("pro_profile >", value, "proProfile");
            return (Criteria) this;
        }

        public Criteria andProProfileGreaterThanOrEqualTo(String value) {
            addCriterion("pro_profile >=", value, "proProfile");
            return (Criteria) this;
        }

        public Criteria andProProfileLessThan(String value) {
            addCriterion("pro_profile <", value, "proProfile");
            return (Criteria) this;
        }

        public Criteria andProProfileLessThanOrEqualTo(String value) {
            addCriterion("pro_profile <=", value, "proProfile");
            return (Criteria) this;
        }

        public Criteria andProProfileLike(String value) {
            addCriterion("pro_profile like", value, "proProfile");
            return (Criteria) this;
        }

        public Criteria andProProfileNotLike(String value) {
            addCriterion("pro_profile not like", value, "proProfile");
            return (Criteria) this;
        }

        public Criteria andProProfileIn(List<String> values) {
            addCriterion("pro_profile in", values, "proProfile");
            return (Criteria) this;
        }

        public Criteria andProProfileNotIn(List<String> values) {
            addCriterion("pro_profile not in", values, "proProfile");
            return (Criteria) this;
        }

        public Criteria andProProfileBetween(String value1, String value2) {
            addCriterion("pro_profile between", value1, value2, "proProfile");
            return (Criteria) this;
        }

        public Criteria andProProfileNotBetween(String value1, String value2) {
            addCriterion("pro_profile not between", value1, value2, "proProfile");
            return (Criteria) this;
        }

        public Criteria andProStartIsNull() {
            addCriterion("pro_start is null");
            return (Criteria) this;
        }

        public Criteria andProStartIsNotNull() {
            addCriterion("pro_start is not null");
            return (Criteria) this;
        }

        public Criteria andProStartEqualTo(Date value) {
            addCriterion("pro_start =", value, "proStart");
            return (Criteria) this;
        }

        public Criteria andProStartNotEqualTo(Date value) {
            addCriterion("pro_start <>", value, "proStart");
            return (Criteria) this;
        }

        public Criteria andProStartGreaterThan(Date value) {
            addCriterion("pro_start >", value, "proStart");
            return (Criteria) this;
        }

        public Criteria andProStartGreaterThanOrEqualTo(Date value) {
            addCriterion("pro_start >=", value, "proStart");
            return (Criteria) this;
        }

        public Criteria andProStartLessThan(Date value) {
            addCriterion("pro_start <", value, "proStart");
            return (Criteria) this;
        }

        public Criteria andProStartLessThanOrEqualTo(Date value) {
            addCriterion("pro_start <=", value, "proStart");
            return (Criteria) this;
        }

        public Criteria andProStartIn(List<Date> values) {
            addCriterion("pro_start in", values, "proStart");
            return (Criteria) this;
        }

        public Criteria andProStartNotIn(List<Date> values) {
            addCriterion("pro_start not in", values, "proStart");
            return (Criteria) this;
        }

        public Criteria andProStartBetween(Date value1, Date value2) {
            addCriterion("pro_start between", value1, value2, "proStart");
            return (Criteria) this;
        }

        public Criteria andProStartNotBetween(Date value1, Date value2) {
            addCriterion("pro_start not between", value1, value2, "proStart");
            return (Criteria) this;
        }

        public Criteria andProDurationIsNull() {
            addCriterion("pro_duration is null");
            return (Criteria) this;
        }

        public Criteria andProDurationIsNotNull() {
            addCriterion("pro_duration is not null");
            return (Criteria) this;
        }

        public Criteria andProDurationEqualTo(String value) {
            addCriterion("pro_duration =", value, "proDuration");
            return (Criteria) this;
        }

        public Criteria andProDurationNotEqualTo(String value) {
            addCriterion("pro_duration <>", value, "proDuration");
            return (Criteria) this;
        }

        public Criteria andProDurationGreaterThan(String value) {
            addCriterion("pro_duration >", value, "proDuration");
            return (Criteria) this;
        }

        public Criteria andProDurationGreaterThanOrEqualTo(String value) {
            addCriterion("pro_duration >=", value, "proDuration");
            return (Criteria) this;
        }

        public Criteria andProDurationLessThan(String value) {
            addCriterion("pro_duration <", value, "proDuration");
            return (Criteria) this;
        }

        public Criteria andProDurationLessThanOrEqualTo(String value) {
            addCriterion("pro_duration <=", value, "proDuration");
            return (Criteria) this;
        }

        public Criteria andProDurationLike(String value) {
            addCriterion("pro_duration like", value, "proDuration");
            return (Criteria) this;
        }

        public Criteria andProDurationNotLike(String value) {
            addCriterion("pro_duration not like", value, "proDuration");
            return (Criteria) this;
        }

        public Criteria andProDurationIn(List<String> values) {
            addCriterion("pro_duration in", values, "proDuration");
            return (Criteria) this;
        }

        public Criteria andProDurationNotIn(List<String> values) {
            addCriterion("pro_duration not in", values, "proDuration");
            return (Criteria) this;
        }

        public Criteria andProDurationBetween(String value1, String value2) {
            addCriterion("pro_duration between", value1, value2, "proDuration");
            return (Criteria) this;
        }

        public Criteria andProDurationNotBetween(String value1, String value2) {
            addCriterion("pro_duration not between", value1, value2, "proDuration");
            return (Criteria) this;
        }

        public Criteria andEnrollDeadlineIsNull() {
            addCriterion("enroll_deadline is null");
            return (Criteria) this;
        }

        public Criteria andEnrollDeadlineIsNotNull() {
            addCriterion("enroll_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andEnrollDeadlineEqualTo(Date value) {
            addCriterion("enroll_deadline =", value, "enrollDeadline");
            return (Criteria) this;
        }

        public Criteria andEnrollDeadlineNotEqualTo(Date value) {
            addCriterion("enroll_deadline <>", value, "enrollDeadline");
            return (Criteria) this;
        }

        public Criteria andEnrollDeadlineGreaterThan(Date value) {
            addCriterion("enroll_deadline >", value, "enrollDeadline");
            return (Criteria) this;
        }

        public Criteria andEnrollDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("enroll_deadline >=", value, "enrollDeadline");
            return (Criteria) this;
        }

        public Criteria andEnrollDeadlineLessThan(Date value) {
            addCriterion("enroll_deadline <", value, "enrollDeadline");
            return (Criteria) this;
        }

        public Criteria andEnrollDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("enroll_deadline <=", value, "enrollDeadline");
            return (Criteria) this;
        }

        public Criteria andEnrollDeadlineIn(List<Date> values) {
            addCriterion("enroll_deadline in", values, "enrollDeadline");
            return (Criteria) this;
        }

        public Criteria andEnrollDeadlineNotIn(List<Date> values) {
            addCriterion("enroll_deadline not in", values, "enrollDeadline");
            return (Criteria) this;
        }

        public Criteria andEnrollDeadlineBetween(Date value1, Date value2) {
            addCriterion("enroll_deadline between", value1, value2, "enrollDeadline");
            return (Criteria) this;
        }

        public Criteria andEnrollDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("enroll_deadline not between", value1, value2, "enrollDeadline");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsIsNull() {
            addCriterion("enroll_requirements is null");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsIsNotNull() {
            addCriterion("enroll_requirements is not null");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsEqualTo(String value) {
            addCriterion("enroll_requirements =", value, "enrollRequirements");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsNotEqualTo(String value) {
            addCriterion("enroll_requirements <>", value, "enrollRequirements");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsGreaterThan(String value) {
            addCriterion("enroll_requirements >", value, "enrollRequirements");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsGreaterThanOrEqualTo(String value) {
            addCriterion("enroll_requirements >=", value, "enrollRequirements");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsLessThan(String value) {
            addCriterion("enroll_requirements <", value, "enrollRequirements");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsLessThanOrEqualTo(String value) {
            addCriterion("enroll_requirements <=", value, "enrollRequirements");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsLike(String value) {
            addCriterion("enroll_requirements like", value, "enrollRequirements");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsNotLike(String value) {
            addCriterion("enroll_requirements not like", value, "enrollRequirements");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsIn(List<String> values) {
            addCriterion("enroll_requirements in", values, "enrollRequirements");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsNotIn(List<String> values) {
            addCriterion("enroll_requirements not in", values, "enrollRequirements");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsBetween(String value1, String value2) {
            addCriterion("enroll_requirements between", value1, value2, "enrollRequirements");
            return (Criteria) this;
        }

        public Criteria andEnrollRequirementsNotBetween(String value1, String value2) {
            addCriterion("enroll_requirements not between", value1, value2, "enrollRequirements");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceIsNull() {
            addCriterion("recruit_place is null");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceIsNotNull() {
            addCriterion("recruit_place is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceEqualTo(String value) {
            addCriterion("recruit_place =", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceNotEqualTo(String value) {
            addCriterion("recruit_place <>", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceGreaterThan(String value) {
            addCriterion("recruit_place >", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_place >=", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceLessThan(String value) {
            addCriterion("recruit_place <", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceLessThanOrEqualTo(String value) {
            addCriterion("recruit_place <=", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceLike(String value) {
            addCriterion("recruit_place like", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceNotLike(String value) {
            addCriterion("recruit_place not like", value, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceIn(List<String> values) {
            addCriterion("recruit_place in", values, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceNotIn(List<String> values) {
            addCriterion("recruit_place not in", values, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceBetween(String value1, String value2) {
            addCriterion("recruit_place between", value1, value2, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitPlaceNotBetween(String value1, String value2) {
            addCriterion("recruit_place not between", value1, value2, "recruitPlace");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeIsNull() {
            addCriterion("recruit_type is null");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeIsNotNull() {
            addCriterion("recruit_type is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeEqualTo(String value) {
            addCriterion("recruit_type =", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeNotEqualTo(String value) {
            addCriterion("recruit_type <>", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeGreaterThan(String value) {
            addCriterion("recruit_type >", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_type >=", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeLessThan(String value) {
            addCriterion("recruit_type <", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeLessThanOrEqualTo(String value) {
            addCriterion("recruit_type <=", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeLike(String value) {
            addCriterion("recruit_type like", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeNotLike(String value) {
            addCriterion("recruit_type not like", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeIn(List<String> values) {
            addCriterion("recruit_type in", values, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeNotIn(List<String> values) {
            addCriterion("recruit_type not in", values, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeBetween(String value1, String value2) {
            addCriterion("recruit_type between", value1, value2, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeNotBetween(String value1, String value2) {
            addCriterion("recruit_type not between", value1, value2, "recruitType");
            return (Criteria) this;
        }

        public Criteria andResearchAreaIsNull() {
            addCriterion("research_area is null");
            return (Criteria) this;
        }

        public Criteria andResearchAreaIsNotNull() {
            addCriterion("research_area is not null");
            return (Criteria) this;
        }

        public Criteria andResearchAreaEqualTo(String value) {
            addCriterion("research_area =", value, "researchArea");
            return (Criteria) this;
        }

        public Criteria andResearchAreaNotEqualTo(String value) {
            addCriterion("research_area <>", value, "researchArea");
            return (Criteria) this;
        }

        public Criteria andResearchAreaGreaterThan(String value) {
            addCriterion("research_area >", value, "researchArea");
            return (Criteria) this;
        }

        public Criteria andResearchAreaGreaterThanOrEqualTo(String value) {
            addCriterion("research_area >=", value, "researchArea");
            return (Criteria) this;
        }

        public Criteria andResearchAreaLessThan(String value) {
            addCriterion("research_area <", value, "researchArea");
            return (Criteria) this;
        }

        public Criteria andResearchAreaLessThanOrEqualTo(String value) {
            addCriterion("research_area <=", value, "researchArea");
            return (Criteria) this;
        }

        public Criteria andResearchAreaLike(String value) {
            addCriterion("research_area like", value, "researchArea");
            return (Criteria) this;
        }

        public Criteria andResearchAreaNotLike(String value) {
            addCriterion("research_area not like", value, "researchArea");
            return (Criteria) this;
        }

        public Criteria andResearchAreaIn(List<String> values) {
            addCriterion("research_area in", values, "researchArea");
            return (Criteria) this;
        }

        public Criteria andResearchAreaNotIn(List<String> values) {
            addCriterion("research_area not in", values, "researchArea");
            return (Criteria) this;
        }

        public Criteria andResearchAreaBetween(String value1, String value2) {
            addCriterion("research_area between", value1, value2, "researchArea");
            return (Criteria) this;
        }

        public Criteria andResearchAreaNotBetween(String value1, String value2) {
            addCriterion("research_area not between", value1, value2, "researchArea");
            return (Criteria) this;
        }

        public Criteria andProRewardIsNull() {
            addCriterion("pro_reward is null");
            return (Criteria) this;
        }

        public Criteria andProRewardIsNotNull() {
            addCriterion("pro_reward is not null");
            return (Criteria) this;
        }

        public Criteria andProRewardEqualTo(String value) {
            addCriterion("pro_reward =", value, "proReward");
            return (Criteria) this;
        }

        public Criteria andProRewardNotEqualTo(String value) {
            addCriterion("pro_reward <>", value, "proReward");
            return (Criteria) this;
        }

        public Criteria andProRewardGreaterThan(String value) {
            addCriterion("pro_reward >", value, "proReward");
            return (Criteria) this;
        }

        public Criteria andProRewardGreaterThanOrEqualTo(String value) {
            addCriterion("pro_reward >=", value, "proReward");
            return (Criteria) this;
        }

        public Criteria andProRewardLessThan(String value) {
            addCriterion("pro_reward <", value, "proReward");
            return (Criteria) this;
        }

        public Criteria andProRewardLessThanOrEqualTo(String value) {
            addCriterion("pro_reward <=", value, "proReward");
            return (Criteria) this;
        }

        public Criteria andProRewardLike(String value) {
            addCriterion("pro_reward like", value, "proReward");
            return (Criteria) this;
        }

        public Criteria andProRewardNotLike(String value) {
            addCriterion("pro_reward not like", value, "proReward");
            return (Criteria) this;
        }

        public Criteria andProRewardIn(List<String> values) {
            addCriterion("pro_reward in", values, "proReward");
            return (Criteria) this;
        }

        public Criteria andProRewardNotIn(List<String> values) {
            addCriterion("pro_reward not in", values, "proReward");
            return (Criteria) this;
        }

        public Criteria andProRewardBetween(String value1, String value2) {
            addCriterion("pro_reward between", value1, value2, "proReward");
            return (Criteria) this;
        }

        public Criteria andProRewardNotBetween(String value1, String value2) {
            addCriterion("pro_reward not between", value1, value2, "proReward");
            return (Criteria) this;
        }

        public Criteria andErollWayIsNull() {
            addCriterion("eroll_way is null");
            return (Criteria) this;
        }

        public Criteria andErollWayIsNotNull() {
            addCriterion("eroll_way is not null");
            return (Criteria) this;
        }

        public Criteria andErollWayEqualTo(String value) {
            addCriterion("eroll_way =", value, "erollWay");
            return (Criteria) this;
        }

        public Criteria andErollWayNotEqualTo(String value) {
            addCriterion("eroll_way <>", value, "erollWay");
            return (Criteria) this;
        }

        public Criteria andErollWayGreaterThan(String value) {
            addCriterion("eroll_way >", value, "erollWay");
            return (Criteria) this;
        }

        public Criteria andErollWayGreaterThanOrEqualTo(String value) {
            addCriterion("eroll_way >=", value, "erollWay");
            return (Criteria) this;
        }

        public Criteria andErollWayLessThan(String value) {
            addCriterion("eroll_way <", value, "erollWay");
            return (Criteria) this;
        }

        public Criteria andErollWayLessThanOrEqualTo(String value) {
            addCriterion("eroll_way <=", value, "erollWay");
            return (Criteria) this;
        }

        public Criteria andErollWayLike(String value) {
            addCriterion("eroll_way like", value, "erollWay");
            return (Criteria) this;
        }

        public Criteria andErollWayNotLike(String value) {
            addCriterion("eroll_way not like", value, "erollWay");
            return (Criteria) this;
        }

        public Criteria andErollWayIn(List<String> values) {
            addCriterion("eroll_way in", values, "erollWay");
            return (Criteria) this;
        }

        public Criteria andErollWayNotIn(List<String> values) {
            addCriterion("eroll_way not in", values, "erollWay");
            return (Criteria) this;
        }

        public Criteria andErollWayBetween(String value1, String value2) {
            addCriterion("eroll_way between", value1, value2, "erollWay");
            return (Criteria) this;
        }

        public Criteria andErollWayNotBetween(String value1, String value2) {
            addCriterion("eroll_way not between", value1, value2, "erollWay");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}