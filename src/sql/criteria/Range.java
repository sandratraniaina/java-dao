package sql.criteria;

import utils.SQLUtils;

public class Range extends Criteria {
    private Object min, max;

    @Override
    public String toQuery(String dbEngine) {
        String query = "";
        query += getMinQuery();
        query += getMaxQuery();
        return query;
    }

    private String getMaxQuery() {
        String query = "";
        if (getMax() != null) {
            query = " AND " + getAttributeName() + " <= " + SQLUtils.toQueryValue(getMax());
        }
        return query;
    }

    private String getMinQuery() {
        String query = "";
        if (getMin() != null) {
            query = " AND " + getAttributeName() + " >= " + SQLUtils.toQueryValue(getMin());
        }
        return query;
    }

    // Contructors
    public Range() {
    }

    public Range(String attributeName, Object min, Object max) {
        super(attributeName);
        setMin(min);
        setMax(max);
    }

    // Getters and setters
    public Object getMin() {
        return min;
    }

    public void setMin(Object min) {
        this.min = min;
    }

    public Object getMax() {
        return max;
    }

    public void setMax(Object max) {
        this.max = max;
    }
}
