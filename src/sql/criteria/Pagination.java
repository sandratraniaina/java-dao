package sql.criteria;

public class Pagination extends Criteria{
    private int offset, limit;

    @Override
    public String toQuery(String dbEngine) throws Exception {
        return null;
    }
    
    //Constructors
    public Pagination(){}
    public Pagination(int offest, int limit) {
        setOffset(offest);
        setLimit(limit);
    }

    //Getters and setters
    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
