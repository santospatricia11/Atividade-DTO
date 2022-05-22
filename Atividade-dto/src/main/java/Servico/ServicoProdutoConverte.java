package Servico;

import java.util.List;

import dto.ProdutoDTO;

public interface ServicoProdutoConverte {
	public List<ProdutoDTO> produtoToDTOList(List<ProdutoDTO> entities);
	public ProdutoDTO dtoProduto(ProdutoDTO dto);
	public ProdutoDTO produtoToDTO(ProdutoDTO entity);


}
