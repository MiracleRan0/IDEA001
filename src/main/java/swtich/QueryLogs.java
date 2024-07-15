package swtich;

public class QueryLogs {
    private String QueryID;
    private String QueryType;
    private String inventoryCheckID;
    private String QueryResults;
    private String QueryDate;

    public String getQueryID() {
        return QueryID;
    }

    public void setQueryID(String QueryID) {
        this.QueryID = QueryID;
    }

    public String getQueryType() {
        return QueryType;
    }

    public void setQueryType(String QueryType) {
        this.QueryType = QueryType;
    }

    public String getInventoryCheckID() {
        return inventoryCheckID;
    }

    public void setInventoryCheckID(String QueryConditions) {
        this.inventoryCheckID = QueryConditions;
    }

    public String getQueryResults() {
        return QueryResults;
    }


    public void setQueryResults(String QueryResults) {
        this.QueryResults = QueryResults;
    }

    public String getQueryDate() {
        return QueryDate;
    }

    public void setQueryDate(String QueryDate) {
        this.QueryDate = QueryDate;
    }
    public QueryLogs(String QueryType,String inventoryCheckID,String QueryDate){
        super();
    }
    public QueryLogs(String QueryID,String QueryType,String inventoryCheckID,String QueryResults,String QueryDate){
        super();
        this.QueryID=QueryID;
        this.QueryType=QueryType;
        this.inventoryCheckID=inventoryCheckID;
        this.QueryResults=QueryResults;
        this.QueryDate=QueryDate;
    }

    @Override
    public String toString() {
        return "QueryLog{" +
                "queryID='" + QueryID + '\'' +
                ", queryType='" + QueryType + '\'' +
                ", queryConditions='" + inventoryCheckID + '\'' +
                ", queryResults='" + QueryResults + '\'' +
                ", queryDate='" + QueryDate + '\'' +
                '}';
    }
}
