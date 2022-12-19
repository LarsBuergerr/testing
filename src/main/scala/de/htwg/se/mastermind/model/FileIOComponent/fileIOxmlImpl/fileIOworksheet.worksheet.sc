import de.htwg.se.mastermind.model.GameComponent.GameBaseImpl.Game
import de.htwg.se.mastermind.model.GameComponent.GameBaseImpl.Matrix
import de.htwg.se.mastermind.model.GameComponent.GameBaseImpl.Field
import de.htwg.se.mastermind.model.GameComponent.GameBaseImpl.Stone
import de.htwg.se.mastermind.model.FileIOComponent.fileIOxmlImpl.FileIO

val fileIO = new FileIO()

val game = new Game(new Field(4, 4 , Stone("G")))
game.field.matrix = game.field.matrix.replaceRow(1, Vector[Stone](Stone("R"), Stone("R"), Stone("R"), Stone("R")))
game.field.matrix = game.field.matrix.replaceRow(2, Vector[Stone](Stone("B"), Stone("B"), Stone("B"), Stone("B")))
game.field.matrix = game.field.matrix.replaceRow(3, Vector[Stone](Stone("Y"), Stone("Y"), Stone("Y"), Stone("Y")))
print(game.field)
fileIO.save(game)


val loadgame = fileIO.load
val game2 = new Game(new Field(4, 4 , Stone("G")))
game2.field.matrix = loadgame

print(game2.field)



