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
			case "��" : return (stateYes);
			case "���" : return (stateNo);
			default : System.out.println("������ �����"); return (state);
			}
		}
		

	public static void main(String[] args) {
		State state = State.WakeUp;
		while (true)
		{
		switch (state)
		{
			case Sleep : System.out.println("�����."); state = State.WakeUp; break;
			case WakeUp : System.out.println("����������.\n��������?"); state= ChangeState(state, State.BeGlad, State.GoToWork); break;
			case GoToWork : System.out.println("������ �� ������.\n��������?"); state= ChangeState(state, State.Sorry, State.DrinkTea); break;
			case DrinkTea : System.out.println("������ ���.\n���������� �������?"); state= ChangeState(state, State.TryToWork, State.Chat); break;
			case Chat : System.out.println("���������� � ��������."); state= State.DrinkTea; break;
			case TryToWork : System.out.println("����������� ������� ����������.\n���� �������?"); state= ChangeState(state, State.Work, State.CheckEmail); break;
			case Work : System.out.println("����������.\n���� �������?"); state= ChangeState(state, State.GoForLunch, State.DrinkTea); break;
			case CheckEmail : System.out.println("�������� �����.\n���� �������?"); state= ChangeState(state, State.GoForLunch, State.DrinkTea); break;
			case GoForLunch : System.out.println("����� �� ����.\n�� �����?"); state= ChangeState(state, State.EatSalad, State.EatLunch); break;
			case EatSalad : System.out.println("������ �����. ������ �� �����."); state = State.EatLunch; break;
			case EatLunch : System.out.println("������ ����."); state= State.TakeTimeOff; break;
			case TakeTimeOff : System.out.println("����������� �����.\n���������?"); state= ChangeState(state, State.GoHome, State.Offense); break;
			case Offense : System.out.println("��������� � ������ �� ������.\n���� �����?"); state= ChangeState(state, State.GoHome, State.Offense); break;
			case GoHome : System.out.println("������ �����."); state= State.GatherForFitness; break;
			case GatherForFitness : System.out.println("���������� �� ������.\n������?"); state= ChangeState(state, State.Relax, State.Fitnes); break;
			case EatBreakfast : System.out.println("������, ... ��������� ����, ... ������������?"); state= State.GatherForFitness; break;
			case Relax : System.out.println("���������.\n���� �����?"); state= ChangeState(state, State.Sleep, State.Hang); break;
			case Fitnes : System.out.println("���-���� ������� �� ������"); state= State.BackHome; break;
			case BackHome : System.out.println("��������� ����� ����� ����������. �� ����� ������)"); state= State.Relax; break;
			case Hang : System.out.println("����������.\n�������?"); state= ChangeState(state, State.GoHomeAtNight, State.Hang); break;
			case GoHomeAtNight : System.out.println("��������� ����� � ����."); state= state.Sleep; break;
			case BeGlad : System.out.println("���������� �����.\n���������?"); state= ChangeState(state, State.EatBreakfast, State.Sleep); break;
			case Sorry : System.out.println("���������� �� ���������."); state= state.DrinkTea; break;
		}
		}	

	}

}
