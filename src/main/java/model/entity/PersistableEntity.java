package model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Setter
@MappedSuperclass
public class PersistableEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String uuid;

  @Column(name = "is_deleted")
  private boolean isDeleted;

}
