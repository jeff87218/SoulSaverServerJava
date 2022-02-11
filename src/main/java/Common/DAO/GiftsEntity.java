package Common.DAO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "gifts", schema = "ghost", catalog = "")
public class GiftsEntity {
    private int id;
    private String name;
    private int itemId;
    private String itemName;
    private int receive;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "itemID", nullable = false)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "itemName", nullable = false, length = 62)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "receive", nullable = false)
    public int getReceive() {
        return receive;
    }

    public void setReceive(int receive) {
        this.receive = receive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftsEntity that = (GiftsEntity) o;
        return id == that.id && itemId == that.itemId && receive == that.receive && Objects.equals(name, that.name) && Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, itemId, itemName, receive);
    }
}
