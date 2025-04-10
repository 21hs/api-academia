<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Avaliação da Aula de Academia</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
            width: 50%;
            margin-left: auto;
            margin-right: auto;
        }
        select, input[type="text"], input[type="submit"] {
            padding: 10px;
            margin: 10px;
            width: 100%;
            max-width: 300px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .result {
            margin-top: 20px;
            padding: 10px;
            background-color: #e2f7e1;
            color: #2d5f2d;
            border: 1px solid #c3f7c1;
            border-radius: 4px;
            display: none;
        }
    </style>
</head>
<body>
    <h2>Avaliação da Aula de Academia</h2>
    <div class="container">
        <form id="formAvaliacao">
            <label for="nome">Seu Nome:</label><br>
            <input type="text" id="nome" name="nome" placeholder="Digite seu nome" required><br>

            <label for="nota">Nota da Aula (1 a 5):</label><br>
            <select id="nota" name="nota" required>
                <option value="1">1 - Péssima</option>
                <option value="2">2 - Ruim</option>
                <option value="3">3 - Regular</option>
                <option value="4">4 - Boa</option>
                <option value="5">5 - Excelente</option>
            </select><br>

            <input type="submit" value="Enviar Avaliação">
        </form>

        <div id="mensagem" class="result"></div>
    </div>

    <script>
        // Função para lidar com o envio do formulário
        document.getElementById("formAvaliacao").addEventListener("submit", function(event) {
            event.preventDefault(); // Evita o envio do formulário e recarregamento da página

            // Pegando os valores do formulário
            var nome = document.getElementById("nome").value;
            var nota = document.getElementById("nota").value;

            // Criando a mensagem com a avaliação
            var mensagem = `Obrigado, ${nome}! Sua avaliação foi registrada: Nota ${nota}/5.`;

            // Exibindo a mensagem
            var resultado = document.getElementById("mensagem");
            resultado.innerHTML = mensagem;
            resultado.style.display = "block"; // Mostra a mensagem

            // Limpando os campos do formulário
            document.getElementById("formAvaliacao").reset();
        });
    </script>
</body>
</html>
