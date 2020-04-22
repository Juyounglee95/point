package library;

public class PointUsed extends AbstractEvent {

    private Long id;
    private Long bookId;
    private Long pointQty;

    public PointUsed(){
        super();
    }
    public PointUsed(PointSystem pointSystem){
        this();
        this.setId(pointSystem.getId());
        this.setBookId(pointSystem.getBookId());
        this.setPointQty(pointSystem.getPointQty());
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getPointQty() {
        return pointQty;
    }

    public void setPointQty(Long pointQty) {
        this.pointQty = pointQty;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
