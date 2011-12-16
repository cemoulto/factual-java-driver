package com.factual.demo;

import static com.factual.FactualTest.read;

import com.factual.Factual;
import com.factual.Query;


public class DemoRowFilterOr {

  public static void main(String[] args) {
    String key = read("key.txt");
    String secret = read("secret.txt");
    Factual factual = new Factual(key, secret);

    // Build a query to find entities where the name begins with "Coffee" OR the telephone is blank:
    Query q = new Query();
    q.or(
        q.criteria("name").beginsWith("Coffee"),
        q.criteria("tel").blank());

    System.out.println(
        factual.fetch("places", q));
  }

}