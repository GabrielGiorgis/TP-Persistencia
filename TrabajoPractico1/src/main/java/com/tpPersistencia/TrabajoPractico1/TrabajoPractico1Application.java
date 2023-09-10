package com.tpPersistencia.TrabajoPractico1;

import com.tpPersistencia.TrabajoPractico1.entidades.*;
import com.tpPersistencia.TrabajoPractico1.repositorios.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.time.LocalDate;

@SpringBootApplication
public class TrabajoPractico1Application {
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TrabajoPractico1Application.class, args);
		System.out.println("Funcionando");
	}
	@Transactional
	@Bean
	CommandLineRunner init(DetallePedidoRepository detallePedidoRepo, UsuarioRepository usuarioRepo, RubroRepository rubroRepo, ProductoRepository productoRepo,PedidoRepository pedidoRepo, FacturaRepository facturaRepo, ClienteRepository clienteRepo, DomicilioRepository domicilioRepo ){
		return args ->{
			System.out.println("---FUNCIONANDO---");
			Producto producto1 = Producto.builder()
					.unidadMedida("Unidades")
					.denominacion("Consumible")
					.precioCompra(100.00)
					.precioVenta(300.00)
					.foto("foto.png")
					.receta("Nro 1")
					.stockActual(100)
					.stockMinimo(0)
					.tiempoEstimadoCocina(15)
					.tipo(Producto.Tipo.MANUFACTURADO)
					.build();
			productoRepository.save(producto1);

			Rubro rubro1 = Rubro.builder()
					.denominacion("Gastronomía")
					.build();
			rubro1.agregarProducto(producto1);
			rubroRepository.save(rubro1);

			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(400.00)
					.build();
			detallePedido1.setProducto(producto1);
			detallePedidoRepository.save(detallePedido1);

			Factura factura1 = Factura.builder()
					.total(600)
					.fecha(LocalDate.now())
					.formapago(Factura.FormaPago.MERCADOPAGO)
					.descuento(3.4)
					.numero(1)
					.build();
			facturaRepository.save(factura1);

			Pedido pedido1 = Pedido.builder()
					.total(700.00)
					.fecha("04/09/2023")
					.horaEstimadaEntrega(LocalDate.now())
					.tipoenvio(Pedido.TipoEnvio.DELIVERY)
					.estado(Pedido.Estado.INICIADO)
					.build();
			pedido1.agregarDetallePedido(detallePedido1);
			pedido1.setFactura(factura1);
			pedidoRepository.save(pedido1);

			Usuario usuario1 = Usuario.builder()
					.rol("Cajero")
					.nombre("Gabriel")
					.password("prog123")
					.build();
			usuario1.agregarPedido(pedido1);
			usuarioRepository.save(usuario1);

			Cliente cliente1 = Cliente.builder()
					.nombre("Carlos")
					.apellido("Miralles")
					.telefono("2615819664")
					.email("carlitos@gmail.com")
					.build();
			cliente1.agregarPedido(pedido1);
			clienteRepository.save(cliente1);

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Belgrano")
					.numero("123")
					.localidad("Ciudad")
					.build();
			domicilio1.agregarPedido(pedido1);
			domicilio1.setCliente(cliente1);
			domicilioRepository.save(domicilio1);

			/*ProductoRepository.save(producto1);
			RubroRepository.save(rubro1);
			UsuarioRepository.save(usuario1);
			PedidoRepository.save(pedido1);
			FacturaRepository.save(factura1);
			DomicilioRepository.save(domicilio1);
			ClienteRepository.save(cliente1);
			DetallePedidoRepository.save(detallePedido1);*/
		};
	}

}
