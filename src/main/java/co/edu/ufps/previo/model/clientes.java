package co.edu.ufps.previo.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String nombre;
    String email;
    String phoneNumber;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Reservas> reservas = new ArrayList<>();



    public void createCustomer(String name, String email, String phoneNumber){

    }

    public void getCustomerById(long id){

    }

    public void getAllCustomers(){

    }

    public void updateCustomer(long id, String name, String email, String phoneNumber){

    }

    public void deleteCustomer(long id){}


}
