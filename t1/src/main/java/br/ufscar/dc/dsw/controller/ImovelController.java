package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.ImobiliariaDAO;
import br.ufscar.dc.dsw.dao.ImovelDAO;
import br.ufscar.dc.dsw.domain.Imobiliaria;
import br.ufscar.dc.dsw.domain.Imovel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/imoveis/*")
public class ImovelController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private ImovelDAO dao;

    @Override
    public void init() {
        dao = new ImovelDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
                
        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/remocao":
                    remove(request, response);
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
                    atualize(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Imovel> listaImoveis = dao.getAll();
        request.setAttribute("listaImoveis", listaImoveis);
        request.setAttribute("contextPath", request.getContextPath().replace("/", ""));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/imovel/lista.jsp");
        dispatcher.forward(request, response);
    }

    private Map<Long, String> getImobiliarias() {
        Map <Long,String> imobiliarias = new HashMap<>();
        for (Imobiliaria imobiliaria: new ImobiliariaDAO().getAll()) {
            imobiliarias.put(imobiliaria.getId(), imobiliaria.getNome());
        }
        return imobiliarias;
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("imobiliarias", getImobiliarias());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/imovel/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Imovel imovel = dao.get(id);
        request.setAttribute("imovel", imovel);
        request.setAttribute("imobiliarias", getImobiliarias());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/imovel/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String endereco = request.getParameter("endereco");
        String cidade = request.getParameter("cidade");
        String descricao = request.getParameter("descricao");
        Float valor = Float.parseFloat(request.getParameter("valor"));

        Long imobiliariaID = Long.parseLong(request.getParameter("imobiliaria"));
        Imobiliaria imobiliaria = new ImobiliariaDAO().get(imobiliariaID);
        
        Imovel imovel = new Imovel(imobiliaria, endereco, cidade, descricao, valor);
        dao.insert(imovel);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        String endereco = request.getParameter("endereco");
        String cidade = request.getParameter("cidade");
        String descricao = request.getParameter("descricao");
        Float valor = Float.parseFloat(request.getParameter("valor"));

        Long imobiliariaID = Long.parseLong(request.getParameter("imobiliaria"));
        Imobiliaria imobiliaria = new ImobiliariaDAO().get(imobiliariaID);
        
        Imovel imovel = new Imovel(id, imobiliaria, endereco, cidade, descricao, valor);
        dao.update(imovel);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Imovel imovel = new Imovel(id);
        dao.delete(imovel);
        response.sendRedirect("lista");
    }
}
