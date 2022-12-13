package com.bosonit.JPACascade.application;


import com.bosonit.JPACascade.domain.entity.Cliente;
import com.bosonit.JPACascade.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class ClienteServiceImp implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);

    }

    @Override
    public Cliente findById(int id) {
        return clienteRepository.findById(id).orElseThrow();
    }


}
