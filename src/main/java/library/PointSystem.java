package library;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="PointSystem_table")
public class PointSystem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long bookId;
    private Long pointQty =(long)100;

    @PostPersist
    public void onPostPersist(){
        PointUsed pointUsed = new PointUsed(this);
        BeanUtils.copyProperties(this, pointUsed);
        pointUsed.publish();


    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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




}
