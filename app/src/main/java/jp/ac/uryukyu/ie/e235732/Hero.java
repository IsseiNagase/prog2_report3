package jp.ac.uryukyu.ie.e235732;

/**
 * ヒーロークラス。
 * ゲームの中で勇者を表すクラスです。
 *
 * <p>ヒーローは名前、HP、攻撃力、生死状態の情報を持ちます。</p>
 * <p>攻撃メソッドやダメージ処理メソッドを提供しています。</p>
 *
 * @author tnal
 * @version 1.0
 */
public class Hero {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * ヒーロークラスのコンストラクタ。
     *
     * @param name       ヒーローの名前
     * @param maximumHP  ヒーローの最大HP
     * @param attack     ヒーローの攻撃力
     */
    public Hero(String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * ヒーローの名前を取得するメソッド。
     *
     * @return ヒーローの名前
     */
    public String getName() {
        return name;
    }

    /**
     * ヒーローの現在のHPを取得するメソッド。
     *
     * @return ヒーローの現在のHP
     */
    public int getHitPoint() {
        return hitPoint;
    }

    /**
     * ヒーローの攻撃力を取得するメソッド。
     *
     * @return ヒーローの攻撃力
     */
    public int getAttack() {
        return attack;
    }

    /**
     * ヒーローが生存しているかどうかを取得するメソッド。
     *
     * @return ヒーローが死亡していれば true、生存していれば false
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * 敵に対して攻撃を行うメソッド。
     *
     * @param enemy 攻撃対象の敵
     */
    public void attack(Enemy enemy) {
        int damage = (int) (Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, enemy.getName(), damage);
        enemy.wounded(damage);
    }

    /**
     * ダメージを受けたときの処理を行うメソッド。
     *
     * @param damage 受けたダメージ
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", name);
        }
    }
}
