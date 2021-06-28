package com.mycompany.enade.controller;

import com.mycompany.enade.dao.FactoryDAO;
import com.mycompany.enade.dao.ResultadoDAO;
import com.mycompany.enade.dao.UsuarioDAO;
import com.mycompany.enade.model.Resultado;
import com.mycompany.enade.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

@Named
@SessionScoped
public class GraficoController implements Serializable {

    private final FactoryDAO factoryDAO = new FactoryDAO();
    private final Class<ResultadoDAO> daoClassResultado;
    private final Class<UsuarioDAO> daoClassUsuario;

    List<Resultado> ultimosDezResultados = new ArrayList<>();
    List<Resultado> totalResultados = new ArrayList<>();
    List<Usuario> totalAlunos = new ArrayList<>();

    private PieChartModel pieModel;
    private BarChartModel barModel;

    public GraficoController() {
        daoClassResultado = ResultadoDAO.class;
        daoClassUsuario = UsuarioDAO.class;
        ultimosDezResultados = factoryDAO.getInstance(daoClassResultado).findUltimosDezResultados();
        totalResultados = factoryDAO.getInstance(daoClassResultado).findAll();
        totalAlunos = factoryDAO.getInstance(daoClassUsuario).findAllAlunos();
    }

    @PostConstruct
    public void init() {
        createPieModel();
        createBarModel();
    }

    private void createPieModel() {
        pieModel = new PieChartModel();

        double qtdAlunosFizeram = (double) totalResultados.size() / (double) totalAlunos.size() * 100;
        pieModel.set("Fez", qtdAlunosFizeram);
        pieModel.set("Não fez", 100 - qtdAlunosFizeram);

        pieModel.setTitle("Alunos que fez a prova");
        pieModel.setLegendPosition("w");
        pieModel.setShadow(false);
    }

    private void createBarModel() {
        ChartSeries notas = new ChartSeries();
        notas.setLabel("Notas");

        ultimosDezResultados.stream().forEach(it -> notas.set(it.getUsuarioidUsuario().getNome(), it.getValorObtido()));

        BarChartModel model = new BarChartModel();
        model.addSeries(notas);
        barModel = model;

        barModel.setTitle("Notas dos 10 alunos");
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Alunos");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Notas");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public List<Resultado> getUltimosDezResultados() {
        return ultimosDezResultados;
    }

    public void setUltimosDezResultados(List<Resultado> ultimosDezResultados) {
        this.ultimosDezResultados = ultimosDezResultados;
    }

    public List<Resultado> getTotalResultados() {
        return totalResultados;
    }

    public void setTotalResultados(List<Resultado> totalResultados) {
        this.totalResultados = totalResultados;
    }

    public List<Usuario> getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(List<Usuario> totalAlunos) {
        this.totalAlunos = totalAlunos;
    }

}
