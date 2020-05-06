package org.bigdatahealth.findu.pojo;

import java.util.ArrayList;
import java.util.List;

public class HotWordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotWordExample() {
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

        public Criteria andHotwordIdIsNull() {
            addCriterion("hotword_id is null");
            return (Criteria) this;
        }

        public Criteria andHotwordIdIsNotNull() {
            addCriterion("hotword_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotwordIdEqualTo(Long value) {
            addCriterion("hotword_id =", value, "hotwordId");
            return (Criteria) this;
        }

        public Criteria andHotwordIdNotEqualTo(Long value) {
            addCriterion("hotword_id <>", value, "hotwordId");
            return (Criteria) this;
        }

        public Criteria andHotwordIdGreaterThan(Long value) {
            addCriterion("hotword_id >", value, "hotwordId");
            return (Criteria) this;
        }

        public Criteria andHotwordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hotword_id >=", value, "hotwordId");
            return (Criteria) this;
        }

        public Criteria andHotwordIdLessThan(Long value) {
            addCriterion("hotword_id <", value, "hotwordId");
            return (Criteria) this;
        }

        public Criteria andHotwordIdLessThanOrEqualTo(Long value) {
            addCriterion("hotword_id <=", value, "hotwordId");
            return (Criteria) this;
        }

        public Criteria andHotwordIdIn(List<Long> values) {
            addCriterion("hotword_id in", values, "hotwordId");
            return (Criteria) this;
        }

        public Criteria andHotwordIdNotIn(List<Long> values) {
            addCriterion("hotword_id not in", values, "hotwordId");
            return (Criteria) this;
        }

        public Criteria andHotwordIdBetween(Long value1, Long value2) {
            addCriterion("hotword_id between", value1, value2, "hotwordId");
            return (Criteria) this;
        }

        public Criteria andHotwordIdNotBetween(Long value1, Long value2) {
            addCriterion("hotword_id not between", value1, value2, "hotwordId");
            return (Criteria) this;
        }

        public Criteria andHotwordContentIsNull() {
            addCriterion("hotword_content is null");
            return (Criteria) this;
        }

        public Criteria andHotwordContentIsNotNull() {
            addCriterion("hotword_content is not null");
            return (Criteria) this;
        }

        public Criteria andHotwordContentEqualTo(String value) {
            addCriterion("hotword_content =", value, "hotwordContent");
            return (Criteria) this;
        }

        public Criteria andHotwordContentNotEqualTo(String value) {
            addCriterion("hotword_content <>", value, "hotwordContent");
            return (Criteria) this;
        }

        public Criteria andHotwordContentGreaterThan(String value) {
            addCriterion("hotword_content >", value, "hotwordContent");
            return (Criteria) this;
        }

        public Criteria andHotwordContentGreaterThanOrEqualTo(String value) {
            addCriterion("hotword_content >=", value, "hotwordContent");
            return (Criteria) this;
        }

        public Criteria andHotwordContentLessThan(String value) {
            addCriterion("hotword_content <", value, "hotwordContent");
            return (Criteria) this;
        }

        public Criteria andHotwordContentLessThanOrEqualTo(String value) {
            addCriterion("hotword_content <=", value, "hotwordContent");
            return (Criteria) this;
        }

        public Criteria andHotwordContentLike(String value) {
            addCriterion("hotword_content like", value, "hotwordContent");
            return (Criteria) this;
        }

        public Criteria andHotwordContentNotLike(String value) {
            addCriterion("hotword_content not like", value, "hotwordContent");
            return (Criteria) this;
        }

        public Criteria andHotwordContentIn(List<String> values) {
            addCriterion("hotword_content in", values, "hotwordContent");
            return (Criteria) this;
        }

        public Criteria andHotwordContentNotIn(List<String> values) {
            addCriterion("hotword_content not in", values, "hotwordContent");
            return (Criteria) this;
        }

        public Criteria andHotwordContentBetween(String value1, String value2) {
            addCriterion("hotword_content between", value1, value2, "hotwordContent");
            return (Criteria) this;
        }

        public Criteria andHotwordContentNotBetween(String value1, String value2) {
            addCriterion("hotword_content not between", value1, value2, "hotwordContent");
            return (Criteria) this;
        }

        public Criteria andHotwordCountIsNull() {
            addCriterion("hotword_count is null");
            return (Criteria) this;
        }

        public Criteria andHotwordCountIsNotNull() {
            addCriterion("hotword_count is not null");
            return (Criteria) this;
        }

        public Criteria andHotwordCountEqualTo(Long value) {
            addCriterion("hotword_count =", value, "hotwordCount");
            return (Criteria) this;
        }

        public Criteria andHotwordCountNotEqualTo(Long value) {
            addCriterion("hotword_count <>", value, "hotwordCount");
            return (Criteria) this;
        }

        public Criteria andHotwordCountGreaterThan(Long value) {
            addCriterion("hotword_count >", value, "hotwordCount");
            return (Criteria) this;
        }

        public Criteria andHotwordCountGreaterThanOrEqualTo(Long value) {
            addCriterion("hotword_count >=", value, "hotwordCount");
            return (Criteria) this;
        }

        public Criteria andHotwordCountLessThan(Long value) {
            addCriterion("hotword_count <", value, "hotwordCount");
            return (Criteria) this;
        }

        public Criteria andHotwordCountLessThanOrEqualTo(Long value) {
            addCriterion("hotword_count <=", value, "hotwordCount");
            return (Criteria) this;
        }

        public Criteria andHotwordCountIn(List<Long> values) {
            addCriterion("hotword_count in", values, "hotwordCount");
            return (Criteria) this;
        }

        public Criteria andHotwordCountNotIn(List<Long> values) {
            addCriterion("hotword_count not in", values, "hotwordCount");
            return (Criteria) this;
        }

        public Criteria andHotwordCountBetween(Long value1, Long value2) {
            addCriterion("hotword_count between", value1, value2, "hotwordCount");
            return (Criteria) this;
        }

        public Criteria andHotwordCountNotBetween(Long value1, Long value2) {
            addCriterion("hotword_count not between", value1, value2, "hotwordCount");
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