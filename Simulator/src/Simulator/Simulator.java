package Simulator;

import java.util.Scanner;

public class Simulator {
	enum State {Sleep, WakeUp, GoToWork, DrinkTea, Chat, TryToWork, Work, 
		CheckEmail, GoForLunch, EatSalad, EatLunch, TakeTimeOff, Offense, GoHome, 
		GatherForFitness, EatBreakfast, Relax, Fitnes, BackHome, Hang, GoHomeAtNight, BeGlad,
		Sorry};
		
		public static State ChangeState (State state, State stateYes, State stateNo) 
		{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String answer = sc.next().toUpperCase();
			switch (answer)
			{
			case "ДА" : return (stateYes);
			case "НЕТ" : return (stateNo);
			default : System.out.println("Ошибка ввода"); return (state);
			}
		}
		

	public static void main(String[] args) {
		State state = State.WakeUp;
		while (true)
		{
		switch (state)
		{
			case Sleep : System.out.println("Спать."); state = State.WakeUp; break;
			case WakeUp : System.out.println("Проснулась.\nВыходной?"); state= ChangeState(state, State.BeGlad, State.GoToWork); break;
			case GoToWork : System.out.println("Прийти на работу.\nОпоздала?"); state= ChangeState(state, State.Sorry, State.DrinkTea); break;
			case DrinkTea : System.out.println("Попить чай.\nНастроение рабочее?"); state= ChangeState(state, State.TryToWork, State.Chat); break;
			case Chat : System.out.println("Пообщаться с коллегми."); state= State.DrinkTea; break;
			case TryToWork : System.out.println("Предпринять попытку поработать.\nЕсть задание?"); state= ChangeState(state, State.Work, State.CheckEmail); break;
			case Work : System.out.println("Поработать.\nПора обедать?"); state= ChangeState(state, State.GoForLunch, State.DrinkTea); break;
			case CheckEmail : System.out.println("Проерить почту.\nПора обедать?"); state= ChangeState(state, State.GoForLunch, State.DrinkTea); break;
			case GoForLunch : System.out.println("Пойти на обед.\nНа диете?"); state= ChangeState(state, State.EatSalad, State.EatLunch); break;
			case EatSalad : System.out.println("Съесть салат. Забить на диету."); state = State.EatLunch; break;
			case EatLunch : System.out.println("Съесть обед."); state= State.TakeTimeOff; break;
			case TakeTimeOff : System.out.println("Отпроситься домой.\nОтпустили?"); state= ChangeState(state, State.GoHome, State.Offense); break;
			case Offense : System.out.println("Обижаться и ничего не делать.\nПора домой?"); state= ChangeState(state, State.GoHome, State.Offense); break;
			case GoHome : System.out.println("Прийти домой."); state= State.GatherForFitness; break;
			case GatherForFitness : System.out.println("Собираться на фитнес.\nУстала?"); state= ChangeState(state, State.Relax, State.Fitnes); break;
			case EatBreakfast : System.out.println("Встать, ... почистить зубы, ... позавтракать?"); state= State.GatherForFitness; break;
			case Relax : System.out.println("Отдохнуть.\nПора спать?"); state= ChangeState(state, State.Sleep, State.Hang); break;
			case Fitnes : System.out.println("Все-таки сходить на фитнес"); state= State.BackHome; break;
			case BackHome : System.out.println("Вернулась домой после тренировки. Ну очень устала)"); state= State.Relax; break;
			case Hang : System.out.println("Тусоваться.\nНадоело?"); state= ChangeState(state, State.GoHomeAtNight, State.Hang); break;
			case GoHomeAtNight : System.out.println("Вернуться домой в ночи."); state= state.Sleep; break;
			case BeGlad : System.out.println("Радоваться жизни.\nВыспалась?"); state= ChangeState(state, State.EatBreakfast, State.Sleep); break;
			case Sorry : System.out.println("Извиняться за опоздание."); state= state.DrinkTea; break;
		}
		}	

	}

}
