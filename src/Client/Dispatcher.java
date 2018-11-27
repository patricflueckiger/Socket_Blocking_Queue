package application.client.gruppe1.controller;

import network.Message;
import network.client.ClientApplicationInterface;
import protocol.server2client.BombDropped;
import protocol.server2client.BombExploded;
import protocol.server2client.ErrorMessage;
import protocol.server2client.GameOver;
import protocol.server2client.PlayerHit;
import protocol.server2client.PlayerJoined;
import protocol.server2client.PlayerMoved;
import protocol.server2client.StartGame;
import protocol.server2client.Update;

public class Dispatcher implements ClientApplicationInterface {

	@Override
	public void handleMessage(Message message) {
		if (message instanceof PlayerJoined) {
			PlayerController controller = ControllerFactory.instance().createPlayerController();
			controller.playerJoined((PlayerJoined)message);
		} else if (message instanceof GameOver) {
			GameController controller = ControllerFactory.instance().createGameController();
			controller.gameOver((GameOver) message);
		}else if (message instanceof StartGame) {
			GameController controller = ControllerFactory.instance().createGameController();
			controller.start(((StartGame) message).getLabyrinth());
		}else if(message instanceof BombDropped) {
			BombController controller = ControllerFactory.instance().createBombController();
			controller.bombDropped((BombDropped) message);
		}else if(message instanceof BombExploded) {
			BombController controller = ControllerFactory.instance().createBombController();
			controller.bombExploded((BombExploded) message);
		}else if(message instanceof ErrorMessage) {
			ErrorController controller = ControllerFactory.instance().createErrorController();
			controller.showError((ErrorMessage) message);
		}else if(message instanceof PlayerHit) {
			PlayerController controller = ControllerFactory.instance().createPlayerController();
			controller.playerHit((PlayerHit) message);
		}else if(message instanceof PlayerMoved) {
			PlayerController controller = ControllerFactory.instance().createPlayerController();
			controller.playerMoved((PlayerMoved) message);
		}else if(message instanceof Update) {
			GameController controller = ControllerFactory.instance().createGameController();
			controller.update(((Update) message).getLabyrinth());
		}
	}
}