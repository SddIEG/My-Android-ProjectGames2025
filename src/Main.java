import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private int difficulty;
    private String language;
    private Map<String, Map<String, String>> translations;

    public Main() {
        this.difficulty = 1;
        this.language = "RU";
        initializeTranslations();
    }

    private void initializeTranslations() {
        translations = new HashMap<>();

        // Русский язык
        Map<String, String> ru = new HashMap<>();
        ru.put("welcome", "Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        ru.put("start_game", "Начинаем играть)");
        ru.put("choose_difficulty", "Выберите уровень сложности (1-легкий, 2-средний, 3-сложный, 4-эксперт, 5-легенда):");
        ru.put("difficulty_selected", "Ты выбрал уровень сложности:\t");
        ru.put("language_auto_changed", "Автоматически установлен китайский язык для легендарной сложности!");
        ru.put("move_prompt", "Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;");
        ru.put("coordinates", "Координаты персонажа - (x: %d, y: %d))");
        ru.put("correct_move", "Ход корректный; Новые координаты: %d, %d\nХод номер: %d");
        ru.put("win_game", "Вы прошли игру!");
        ru.put("incorrect_move", "Неккоректный ход");
        ru.put("lives", "Количество жизней:\t");
        ru.put("game_over", "Игра окончена! У вас закончились жизни.");
        ru.put("come_again", "Жаль, приходи еще!");
        ru.put("invalid_input", "Данные введены неккоректно");
        ru.put("easy", "легкий");
        ru.put("medium", "средний");
        ru.put("hard", "сложный");
        ru.put("expert", "эксперт");
        ru.put("legend", "легенда (китайский язык)");

        // Китайский язык
        Map<String, String> cn = new HashMap<>();
        cn.put("welcome", "你好！你准备好开始游戏了吗？(写: 是 或 否)");
        cn.put("start_game", "开始游戏)");
        cn.put("choose_difficulty", "选择难度级别 (1-简单, 2-中等, 3-困难, 4-专家, 5-传奇):");
        cn.put("difficulty_selected", "你选择的难度级别:\t");
        cn.put("language_auto_changed", "传奇难度已自动设置为中文语言！");
        cn.put("move_prompt", "输入角色移动的位置(只能垂直和水平移动一个格子;");
        cn.put("coordinates", "角色坐标 - (x: %d, y: %d))");
        cn.put("correct_move", "移动正确; 新坐标: %d, %d\n移动编号: %d");
        cn.put("win_game", "你赢了游戏!");
        cn.put("incorrect_move", "移动不正确");
        cn.put("lives", "生命数量:\t");
        cn.put("game_over", "游戏结束！你的生命用完了。");
        cn.put("come_again", "太遗憾了，再来吧!");
        cn.put("invalid_input", "输入数据不正确");
        cn.put("easy", "简单");
        cn.put("medium", "中等");
        cn.put("hard", "困难");
        cn.put("expert", "专家");
        cn.put("legend", "传奇 (中文语言)");

        translations.put("RU", ru);
        translations.put("CN", cn);
    }

    public void configureSettings(Scanner scanner) {
        configureDifficulty(scanner);
    }

    private void configureDifficulty(Scanner scanner) {
        System.out.println(getText("choose_difficulty"));
        try {
            int diff = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (diff >= 1 && diff <= 5) {
                this.difficulty = diff;

                // Автоматически меняем язык на китайский для 5 уровня сложности
                if (diff == 5) {
                    this.language = "CN";
                    System.out.println(getText("language_auto_changed"));
                }

                System.out.println(getText("difficulty_selected") + getDifficultyName());
            } else {
                System.out.println(getText("invalid_input"));
                System.out.println("使用默认难度: " + getDifficultyName());
            }
        } catch (Exception e) {
            System.out.println(getText("invalid_input"));
            System.out.println("使用默认难度: " + getDifficultyName());
            scanner.nextLine(); // clear invalid input
        }
    }

    public String getText(String key) {
        Map<String, String> langMap = translations.get(language);
        return langMap.getOrDefault(key, "[" + key + "]");
    }

    public String getText(String key, Object... args) {
        String text = getText(key);
        return String.format(text, args);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getLanguage() {
        return language;
    }

    public String getDifficultyName() {
        switch (difficulty) {
            case 1: return getText("easy");
            case 2: return getText("medium");
            case 3: return getText("hard");
            case 4: return getText("expert");
            case 5: return getText("legend");
            default: return getText("easy");
        }
    }

    // Метод для получения модификаторов сложности
    public double getDifficultyModifier() {
        switch (difficulty) {
            case 1: return 0.7; // Легкий - монстры слабее
            case 2: return 1.0; // Средний - стандартная сложность
            case 3: return 1.3; // Сложный - монстры сильнее
            case 4: return 1.6; // Эксперт - очень сложно
            case 5: return 2.0; // Легенда - экстремальная сложность + китайский язык
            default: return 1.0;
        }
    }
}