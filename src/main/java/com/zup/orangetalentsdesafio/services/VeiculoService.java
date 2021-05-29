package com.zup.orangetalentsdesafio.services;

import com.zup.orangetalentsdesafio.config.FIPEClient;
import com.zup.orangetalentsdesafio.entities.Usuario;
import com.zup.orangetalentsdesafio.entities.Veiculo;
import com.zup.orangetalentsdesafio.entities.models.Ano;
import com.zup.orangetalentsdesafio.entities.models.Marca;
import com.zup.orangetalentsdesafio.entities.models.Modelo;
import com.zup.orangetalentsdesafio.entities.models.VeiculoDetalhe;
import com.zup.orangetalentsdesafio.exceptions.AnoNotFoundException;
import com.zup.orangetalentsdesafio.exceptions.MarcaNotFoundException;
import com.zup.orangetalentsdesafio.exceptions.ModeloNotFoundException;
import com.zup.orangetalentsdesafio.repositories.UsuarioRepository;
import com.zup.orangetalentsdesafio.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    public static String getDiaSemana(){
        return new DateFormatSymbols().getWeekdays()[Calendar.getInstance().get(Calendar.DAY_OF_WEEK)];
    }

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FIPEClient fipeClient;

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Veiculo cadastrar(Veiculo veiculo, Long usuarioId) throws MarcaNotFoundException,
            ModeloNotFoundException, AnoNotFoundException {
        Optional<Usuario> usuarioExiste = usuarioRepository.findById(usuarioId);

        Marca marcas = fipeClient.getMarcas()
                                 .stream()
                                 .filter(ma -> ma.getNome().equalsIgnoreCase(veiculo.getMarca()))
                                 .findFirst()
                                 .orElseThrow(MarcaNotFoundException::new);
        String codigoMarca = marcas.getCodigo();

        Modelo.Modelos modelos = fipeClient.getModelos(codigoMarca).getModelos()
                                           .stream()
                                           .filter(mo -> mo.getNome().equalsIgnoreCase(veiculo.getModelo()))
                                           .findFirst()
                                           .orElseThrow(ModeloNotFoundException::new);
        Integer codigoModelo = modelos.getCodigo();

        Ano ano = fipeClient.getAnos(codigoMarca, codigoModelo)
                            .stream()
                            .filter(an -> an.getCodigo().equals(veiculo.getAno()))
                            .findFirst()
                            .orElseThrow(AnoNotFoundException::new);
        String codigoAno = ano.getCodigo();

        VeiculoDetalhe veiculoDetalhe = fipeClient.getVeiculoDetalhe(codigoMarca, codigoModelo, codigoAno);
        veiculoDetalhe.setValor(veiculoDetalhe.getValor());
        setInfoRodizioVeiculo(veiculo);

        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);

        veiculo.setUsuario(usuario);
        return veiculoRepository.save(veiculo);
    }

    private void setInfoRodizioVeiculo(Veiculo veiculo) {
        String diaSemana = "";
        String ultimoNumeroAno = veiculo.getAno().substring(veiculo.getAno().length() - 1);

        switch(ultimoNumeroAno) {
            case "0":
            case "1":
                diaSemana = "segunda-feira";
                break;
            case "2":
            case "3":
                diaSemana = "terça-feira";
                break;
            case "4":
            case "5":
                diaSemana = "quarta-feira";
                break;
            case "6":
            case "7":
                diaSemana = "quinta-feira";
                break;
            case "8":
            case "9":
                diaSemana = "sexta-feira";
                break;
        }

        veiculo.setDiaRodizio(diaSemana);

        if(diaSemana.equals(getDiaSemana())) {
            veiculo.setRodizioAtivo(true);
        }
    }
}
