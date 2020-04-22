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
    private Long pointQty;

    @PostPersist
    public void onPostPersist(){
        PointUsed pointUsed = new PointUsed();
        BeanUtils.copyProperties(this, pointUsed);
        pointUsed.publish();


        PointsReturned pointsReturned = new PointsReturned();
        BeanUtils.copyProperties(this, pointsReturned);
        pointsReturned.publish();


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
