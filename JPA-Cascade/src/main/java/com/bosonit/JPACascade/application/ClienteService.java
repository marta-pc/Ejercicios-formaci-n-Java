package com.bosonit.JPACascade.application;

import com.bosonit.JPACascade.domain.entity.Cliente;

public interface ClienteService {

    Cliente addCliente(Cliente cliente);


    Cliente findById(int id);
}
