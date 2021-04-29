# rodo-consulta-cpf-rf
# Consulta situação no site da receita



### Execução

  1. Automatizar a extração da consulta à página: (https://servicos.receita.fazenda.gov.br/servicos/cpf/consultasituacao/ConsultaPublicaSonoro.asp?CPF=&NASCIMENTO=) 
  2. Remove o Html, removendo todas as tags (somente as tags, não o texto dentro delas), utilizando espressões regulares.
  3. Salva o conteúdo do html na tabela tb_html (esta tabela tem 2 colunas: id int auto_increment e html varchar).
  4. Exibi a situação cadastral em um **JOptionPane** 


### Observações:
* O banco de dados é em memória. Sempre que a aplicação terminar, os dados serão perdidos. 
* Não é nesessario resolver o captcha, apenas exibí-lo em um JOptionPane (inputDialog)
