# explorando_marte
de Lucas Eneas

Nesse projeto serão lancadas duas sondas espaciais em um plano de tamanho definido pelo usuário ,que se moverão uma de cada vez, por linhas de comandos estabelecidas na utilização do sistema.

O usuário informara o tamanho do planalto no formato de plano cartesiano (Latitude X  e Longitude Y), não podendo ser menor que 1 x 1, pois as sondas não conseguirão se mover. Após isso irá digitar o nome(String) da primeira sonda com limite de 7 caracteres, as coordenadas x e y(int) que sera lançada, a direção(Norte = N, Sul = S, Leste = L, Oeste = O) e o percuso que que irá fazer, sendo E = Virar a esquerda, D = Virar a direita  e M = Mover em frente (Ex.: DMMEMMDM), e depois respectivamente os dados da segunda Sonda.

Digitando os dados o sistema, ele irá imprimir o resultado no Console junto com uma interface gráfica em JFrame, mostrando a posição e direção que cada sonda ficou após seguir os comandos.

Foi criado a classe Teste para ser executada com o JUnit 5, com todos os testes que foram realizados na aplicação.
