package co.edu.ufps.previo.service;

import co.edu.ufps.previo.model.clientes;
import co.edu.ufps.previo.repository.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clientesService {

    @Autowired
    private clienteRepository clienteRepository;

    //registra un nuevo cliente
    public void createCustomer(String name, String email, String phoneNumber) {
        return clienteRepository.save(cliente);
    }

    public clientes getCustomerById(long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public List<clientes> getAllCustomers(){
        return clienteRepository.findAll();
    }

    public clientes updateCustomer(long id, String name, String email, String phoneNumber){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setEmail(clienteActualizado.getEmail());
            cliente.setTelefono(clienteActualizado.getTelefono());
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public void deleteCustomer(long id){}

}
