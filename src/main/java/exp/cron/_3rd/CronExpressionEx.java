package exp.cron._3rd;

import java.text.ParseException;
import java.util.Set;
import java.util.StringTokenizer;

import org.quartz.CronExpression;

public class CronExpressionEx extends CronExpression {
  public static final Integer ALL_SPEC = new Integer(99);
  public static final int NO_SPEC_INT = 98;
  private String secondsExp;
  private String minutesExp;
  private String hoursExp;
  private String daysOfMonthExp;
  private String monthsExp;
  private String daysOfWeekExp;

  public CronExpressionEx(String cronExpression)
    throws ParseException
  {
    super(cronExpression);

    StringTokenizer exprsTok = new StringTokenizer(cronExpression, " \t", false);
    this.secondsExp = exprsTok.nextToken().trim();
    this.minutesExp = exprsTok.nextToken().trim();
    this.hoursExp = exprsTok.nextToken().trim();
    this.daysOfMonthExp = exprsTok.nextToken().trim();
    this.monthsExp = exprsTok.nextToken().trim();
    this.daysOfWeekExp = exprsTok.nextToken().trim();
  }

  public Set getSecondsSet() {
    return this.seconds;
  }

  public String getSecondsField() {
    return getExpressionSetSummary(this.seconds);
  }

  public Set getMinutesSet() {
    return this.minutes;
  }

  public String getMinutesField() {
    return getExpressionSetSummary(this.minutes);
  }

  public Set getHoursSet() {
    return this.hours;
  }

  public String getHoursField() {
    return getExpressionSetSummary(this.hours);
  }

  public Set getDaysOfMonthSet() {
    return this.daysOfMonth;
  }

  public String getDaysOfMonthField() {
    return getExpressionSetSummary(this.daysOfMonth);
  }

  public Set getMonthsSet() {
    return this.months;
  }

  public String getMonthsField() {
    return getExpressionSetSummary(this.months);
  }

  public Set getDaysOfWeekSet() {
    return this.daysOfWeek;
  }

  public String getDaysOfWeekField() {
    return getExpressionSetSummary(this.daysOfWeek);
  }

  public String getSecondsExp() {
    return this.secondsExp;
  }

  public String getMinutesExp() {
    return this.minutesExp;
  }

  public String getHoursExp() {
    return this.hoursExp;
  }

  public String getDaysOfMonthExp() {
    return this.daysOfMonthExp;
  }

  public String getMonthsExp() {
    return this.monthsExp;
  }

  public String getDaysOfWeekExp() {
    return this.daysOfWeekExp;
  }
}
