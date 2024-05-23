package sql.criteria;

public abstract class Criteria {
    private String attributeName;

    public abstract String toQuery(String dbEngine) throws Exception;
    
    //Constructors
    public Criteria(){}
    public Criteria(String attributeName) {
        setAttributeName(attributeName);
    }

    //Getters and setter
    public String getAttributeName() {
        return attributeName;
    }
    
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}
