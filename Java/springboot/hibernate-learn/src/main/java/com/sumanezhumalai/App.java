package com.sumanezhumalai;

import com.sumanezhumalai.concept.Configurations;
import com.sumanezhumalai.concept.EHcache;
import com.sumanezhumalai.concept.GetVsLoad;
import com.sumanezhumalai.concept.HqlQuery;
import com.sumanezhumalai.concept.LazyEagerHibernate;
import com.sumanezhumalai.concept.Basic;

public class App {
        public static void main(String[] args) {
                // Basic.basicConcept();
                // LazyEagerHibernate.LazyEagerHibernateConcept();
                // HqlQuery.hqlQueryConcept();
                // GetVsLoad.getVsLoadConcept();
                EHcache.EHcacheConcept();

                // close heavy resources (Session Factory0)
                Configurations.closeResources();
        }
}
