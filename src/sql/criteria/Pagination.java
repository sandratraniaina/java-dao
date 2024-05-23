package sql.criteria;

public class Pagination extends Criteria{
    private int offset, limit;

    @Override
    public String toQuery(String dbEngine) throws Exception {
        if (dbEngine.equalsIgnoreCase("oracle")) {
            return " FETCH FIRST " + getLimit() + " ONLY OFFSET " + getOffset() + " ROWS";
        } else if (dbEngine.equalsIgnoreCase("mssqlserver")) {
            return " OFFSET " + getOffset() + " FETCH NEXT " + getLimit() + " ROWS ONLY";
        } else if (dbEngine.equalsIgnoreCase("mysql") || dbEngine.equalsIgnoreCase("postgres")) {
            return " LIMIT " + getLimit() + " OFFSET " + getOffset();
        }
        throw new Exception("Invalid database engine.");
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
