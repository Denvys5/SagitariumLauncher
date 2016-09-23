package net.launcher.run;

import com.denvys5.Menu;

public class Settings
{
	/** Настройка заголовка лаунчера */
	public static final String  title		         = "Sagitarium Launcher"; //Заголовок лаунчера
	public static final String  titleInGame  	     = "Sagitarium Launcher"; //Заголовок лаунчера после авторизации
	public static final String  baseconf		     =  System.getProperty("user.home").substring(3) + "/AppData/Roaming/Sagitarium"; //Папка с файлом конфигурации
	public static final String  pathconst		     =  System.getProperty("user.home").substring(3) + "/AppData/Roaming/Sagitarium/%SERVERNAME%"; //Конструктор пути к папке с MC
	public static final String  skins                = "minenew/MinecraftSkins/"; //Папка скинов
	public static final String  cloaks               = "minenew/MinecraftCloaks/"; //Папка плащей
	/** Параметры подключения */
	public static final String  domain	 	         = "sagitarium.org";//Домен сайта
	public static final String  siteDir		         = "minenew";//Папка с файлами лаунчера на сайте
	public static final String  updateFile		     = "https://sagitarium.org/minenew/launcher/SagitariumLauncher";//Ссылка на обновления лаунчера. Не писать на конце ".exe .jar"!
	public static final String  buyVauncherLink      = "https://sagitarium.org"; //Ссылка на страницу покупки ваучеров
	public static final String[] p = {"wireshark", "cheat"};  //Список запрещенных процессов.
	public static final String http = "http://";   //Протокол подключения https:// если есть ssl сертификат
        
	public static String[] servers =
	{
		"Offline, localhost, 25565, 1.7.10",
	};

	/** Настройка панели ссылок **/
	public static final String[] links = 
	{
		//Для отключения добавьте в адрес ссылки #
		" Регистрация ::https://sagitarium.org/?a=14PYhNyI7QA8Y",
		" Подать заявку ::https://sagitarium.org/?a=14RcVa91iCfUE"
	};

	/** Настройки структуры лаунчера */
	public static boolean useAutoenter	         =  false;  //Использовать функцию автозахода на выбранный сервер
	public static boolean useRegister		     =  false;   //Использовать Регистрацию в лаунчере
	public static boolean useMulticlient		 =  true;   //Использовать функцию "по клиенту на сервер"
	public static boolean useStandartWB		     =  true;   //Использовать стандартный браузер для открытия ссылок
	public static boolean usePersonal		     =  false;   //Использовать Личный кабинет
	public static boolean customframe 		     =  true;   //Использовать кастомный фрейм
	public static boolean useConsoleHider		 =  true;  //Использовать скрытие консоли клиента
	public static boolean useModCheckerTimer	 =  true;   //Перепроверка jar через 30 секунд
	public static int     useModCheckerint       =  2;      //Количество раз перепроверки jar во время игры
	public static boolean assetsfolder           =  false;  //Скачивать assets из папки, или из архива (true=из папки false=из архива) в connect.php должно быть так же.

	public static final String protectionKey	 = ""; //Ключ защиты сессии. Никому его не говорите.
	public static final String key1              = ""; //16 Character Key Ключ пост запросов
	public static final String key2              = ""; //16 Character Key Ключ пост запросов
	

	public static boolean debug		 	         =  true; //Отображать все действия лаунчера (отладка)(true/false)
	public static boolean drawTracers		     =  false; //Отрисовывать границы элементов лаунчера
	public static final String masterVersion     = "1.8"; //Версия лаунчера

	public static boolean patchDir 		         =  true; //Использовать автоматическую замену директории игры (true/false)
	
	public static void onStart() {
		Menu.setModlist();
	}
	public static void onStartMinecraft() {}
	
}
