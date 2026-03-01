package Storage_Control.SC.controles.de.estoque.dto.saida.produtos;


import org.springframework.data.domain.Page;

public record ListaDeProdutosDto(ProdutosAllInfoDto produtoInfos, Page<ProdutosListadosDto> produtosListados) {

}
