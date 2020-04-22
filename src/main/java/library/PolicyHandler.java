package library;

import library.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    PointSystemRepository pointSystemRepository;
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCanceled_ReturnPoint(@Payload ReservationCanceled reservationCanceled){

        if(reservationCanceled.isMe()){
            System.out.println("##### Reservation Canceled : " + reservationCanceled.toJson());
            PointsReturned pointsReturned = new PointsReturned();
            pointsReturned.setId(reservationCanceled.getId());
            pointsReturned.setPointQty(pointSystemRepository.findById(reservationCanceled.getId()).get().getPointQty());
            BeanUtils.copyProperties(this, pointsReturned);
            pointsReturned.publish();

        }
    }

}
