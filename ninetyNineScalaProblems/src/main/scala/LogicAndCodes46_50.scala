



<!DOCTYPE html>
<html lang="en" class=" is-copy-enabled">
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# object: http://ogp.me/ns/object# article: http://ogp.me/ns/article# profile: http://ogp.me/ns/profile#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">
    <meta name="viewport" content="width=1020">
    
    
    <title>ScalaPlay/LogicAndCodes46_50.scala at master · archeg/ScalaPlay</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub">
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub">
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png">
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png">
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png">
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png">
    <meta property="fb:app_id" content="1401488693436528">

      <meta content="@github" name="twitter:site" /><meta content="summary" name="twitter:card" /><meta content="archeg/ScalaPlay" name="twitter:title" /><meta content="ScalaPlay - Repository where I play with scala. Nothing of importance." name="twitter:description" /><meta content="https://avatars0.githubusercontent.com/u/700094?v=3&amp;s=400" name="twitter:image:src" />
      <meta content="GitHub" property="og:site_name" /><meta content="object" property="og:type" /><meta content="https://avatars0.githubusercontent.com/u/700094?v=3&amp;s=400" property="og:image" /><meta content="archeg/ScalaPlay" property="og:title" /><meta content="https://github.com/archeg/ScalaPlay" property="og:url" /><meta content="ScalaPlay - Repository where I play with scala. Nothing of importance." property="og:description" />
      <meta name="browser-stats-url" content="https://api.github.com/_private/browser/stats">
    <meta name="browser-errors-url" content="https://api.github.com/_private/browser/errors">
    <link rel="assets" href="https://assets-cdn.github.com/">
    <link rel="web-socket" href="wss://live.github.com/_sockets/NzAwMDk0OmUwMTRjMWE2ZmQwMzdmM2MwMWRkMzM0NWNkZTQ5ODIyOmJkNWY2MmYxOTc3MWIyNDk4MWVjMWFmYjJkZGE4ODNiNTlmMjlkODVhOWNkNjIzMTBkNWQ1ZGJkZDZkMWJmNTU=--8d827bad8ac79241619d72ceb5ce3afb74a4952a">
    <meta name="pjax-timeout" content="1000">
    <link rel="sudo-modal" href="/sessions/sudo_modal">

    <meta name="msapplication-TileImage" content="/windows-tile.png">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="selected-link" value="repo_source" data-pjax-transient>

    <meta name="google-site-verification" content="KT5gs8h0wvaagLKAVWq8bbeNwnZZK1r1XQysX3xurLU">
    <meta name="google-analytics" content="UA-3769691-2">

<meta content="collector.githubapp.com" name="octolytics-host" /><meta content="github" name="octolytics-app-id" /><meta content="1FDFE7A5:448A:11D5391C:5670A2C7" name="octolytics-dimension-request_id" /><meta content="700094" name="octolytics-actor-id" /><meta content="archeg" name="octolytics-actor-login" /><meta content="36ffb8bf8138a474da1e7d225cbe063bf44ca2befebe1f9bda1e644a749d0c74" name="octolytics-actor-hash" />
<meta content="/&lt;user-name&gt;/&lt;repo-name&gt;/blob/show" data-pjax-transient="true" name="analytics-location" />
<meta content="Rails, view, blob#show" data-pjax-transient="true" name="analytics-event" />


  <meta class="js-ga-set" name="dimension1" content="Logged In">



        <meta name="hostname" content="github.com">
    <meta name="user-login" content="archeg">

        <meta name="expected-hostname" content="github.com">

      <link rel="mask-icon" href="https://assets-cdn.github.com/pinned-octocat.svg" color="#4078c0">
      <link rel="icon" type="image/x-icon" href="https://assets-cdn.github.com/favicon.ico">

    <meta content="c8ba129f3cd8063df505087e410775fa587c3890" name="form-nonce" />

    <link crossorigin="anonymous" href="https://assets-cdn.github.com/assets/github-502ab50993b65c1ac75efa286ffd5304245f6c9bb4171ac014fbcf92f6f688de.css" integrity="sha256-UCq1CZO2XBrHXvoob/1TBCRfbJu0FxrAFPvPkvb2iN4=" media="all" rel="stylesheet" />
    <link crossorigin="anonymous" href="https://assets-cdn.github.com/assets/github2-ebf42d255e330ca3f7549dac879de43cf65f82c36670b5628077508fdf3b1c44.css" integrity="sha256-6/QtJV4zDKP3VJ2sh53kPPZfgsNmcLVigHdQj987HEQ=" media="all" rel="stylesheet" />
    
    


    <meta http-equiv="x-pjax-version" content="cd9958d45e48e8e3157a320e9c346eaa">

      
  <meta name="description" content="ScalaPlay - Repository where I play with scala. Nothing of importance.">
  <meta name="go-import" content="github.com/archeg/ScalaPlay git https://github.com/archeg/ScalaPlay.git">

  <meta content="700094" name="octolytics-dimension-user_id" /><meta content="archeg" name="octolytics-dimension-user_login" /><meta content="48056280" name="octolytics-dimension-repository_id" /><meta content="archeg/ScalaPlay" name="octolytics-dimension-repository_nwo" /><meta content="true" name="octolytics-dimension-repository_public" /><meta content="false" name="octolytics-dimension-repository_is_fork" /><meta content="48056280" name="octolytics-dimension-repository_network_root_id" /><meta content="archeg/ScalaPlay" name="octolytics-dimension-repository_network_root_nwo" />
  <link href="https://github.com/archeg/ScalaPlay/commits/master.atom" rel="alternate" title="Recent Commits to ScalaPlay:master" type="application/atom+xml">

  </head>


  <body class="logged_in   env-production windows vis-public page-blob">
    <a href="#start-of-content" tabindex="1" class="accessibility-aid js-skip-to-content">Skip to content</a>

    
    
    



      <div class="header header-logged-in true" role="banner">
  <div class="container clearfix">

    <a class="header-logo-invertocat" href="https://github.com/" data-hotkey="g d" aria-label="Homepage" data-ga-click="Header, go to dashboard, icon:logo">
  <span class="mega-octicon octicon-mark-github"></span>
</a>


      <div class="site-search repo-scope js-site-search" role="search">
          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/search" class="js-site-search-form" data-global-search-url="/search" data-repo-search-url="/archeg/ScalaPlay/search" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
  <label class="js-chromeless-input-container form-control">
    <div class="scope-badge">This repository</div>
    <input type="text"
      class="js-site-search-focus js-site-search-field is-clearable chromeless-input"
      data-hotkey="s"
      name="q"
      placeholder="Search"
      aria-label="Search this repository"
      data-global-scope-placeholder="Search GitHub"
      data-repo-scope-placeholder="Search"
      tabindex="1"
      autocapitalize="off">
  </label>
</form>
      </div>

      <ul class="header-nav left" role="navigation">
        <li class="header-nav-item">
          <a href="/pulls" class="js-selected-navigation-item header-nav-link" data-ga-click="Header, click, Nav menu - item:pulls context:user" data-hotkey="g p" data-selected-links="/pulls /pulls/assigned /pulls/mentioned /pulls">
            Pull requests
</a>        </li>
        <li class="header-nav-item">
          <a href="/issues" class="js-selected-navigation-item header-nav-link" data-ga-click="Header, click, Nav menu - item:issues context:user" data-hotkey="g i" data-selected-links="/issues /issues/assigned /issues/mentioned /issues">
            Issues
</a>        </li>
          <li class="header-nav-item">
            <a class="header-nav-link" href="https://gist.github.com/" data-ga-click="Header, go to gist, text:gist">Gist</a>
          </li>
      </ul>

    
<ul class="header-nav user-nav right" id="user-links">
  <li class="header-nav-item">
      <span class="js-socket-channel js-updatable-content"
        data-channel="notification-changed:archeg"
        data-url="/notifications/header">
      <a href="/notifications" aria-label="You have unread notifications" class="header-nav-link notification-indicator tooltipped tooltipped-s" data-ga-click="Header, go to notifications, icon:unread" data-hotkey="g n">
          <span class="mail-status unread"></span>
          <span class="octicon octicon-bell"></span>
</a>  </span>

  </li>

  <li class="header-nav-item dropdown js-menu-container">
    <a class="header-nav-link tooltipped tooltipped-s js-menu-target" href="/new"
       aria-label="Create new…"
       data-ga-click="Header, create new, icon:add">
      <span class="octicon octicon-plus left"></span>
      <span class="dropdown-caret"></span>
    </a>

    <div class="dropdown-menu-content js-menu-content">
      <ul class="dropdown-menu dropdown-menu-sw">
        
<a class="dropdown-item" href="/new" data-ga-click="Header, create new repository">
  New repository
</a>


  <a class="dropdown-item" href="/organizations/new" data-ga-click="Header, create new organization">
    New organization
  </a>



  <div class="dropdown-divider"></div>
  <div class="dropdown-header">
    <span title="archeg/ScalaPlay">This repository</span>
  </div>
    <a class="dropdown-item" href="/archeg/ScalaPlay/issues/new" data-ga-click="Header, create new issue">
      New issue
    </a>
    <a class="dropdown-item" href="/archeg/ScalaPlay/settings/collaboration" data-ga-click="Header, create new collaborator">
      New collaborator
    </a>

      </ul>
    </div>
  </li>

  <li class="header-nav-item dropdown js-menu-container">
    <a class="header-nav-link name tooltipped tooltipped-sw js-menu-target" href="/archeg"
       aria-label="View profile and more"
       data-ga-click="Header, show menu, icon:avatar">
      <img alt="@archeg" class="avatar" height="20" src="https://avatars1.githubusercontent.com/u/700094?v=3&amp;s=40" width="20" />
      <span class="dropdown-caret"></span>
    </a>

    <div class="dropdown-menu-content js-menu-content">
      <div class="dropdown-menu  dropdown-menu-sw">
        <div class=" dropdown-header header-nav-current-user css-truncate">
            Signed in as <strong class="css-truncate-target">archeg</strong>

        </div>


        <div class="dropdown-divider"></div>

          <a class="dropdown-item" href="/archeg" data-ga-click="Header, go to profile, text:your profile">
            Your profile
          </a>
        <a class="dropdown-item" href="/stars" data-ga-click="Header, go to starred repos, text:your stars">
          Your stars
        </a>
        <a class="dropdown-item" href="/explore" data-ga-click="Header, go to explore, text:explore">
          Explore
        </a>
          <a class="dropdown-item" href="/integrations" data-ga-click="Header, go to integrations, text:integrations">
            Integrations
          </a>
        <a class="dropdown-item" href="https://help.github.com" data-ga-click="Header, go to help, text:help">
          Help
        </a>

          <div class="dropdown-divider"></div>

          <a class="dropdown-item" href="/settings/profile" data-ga-click="Header, go to settings, icon:settings">
            Settings
          </a>

          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/logout" class="logout-form" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="kyJouRZ7O0zYkOex31mV5aYMmUbyEvXNPqMQaHpXJ5WQXpUC2aQ21VK/5Jsz6ja7+YM7RFgp7VQSCw/5oGoihw==" /></div>
            <button class="dropdown-item dropdown-signout" data-ga-click="Header, sign out, icon:logout">
              Sign out
            </button>
</form>
      </div>
    </div>
  </li>
</ul>


    
  </div>
</div>

      

      


    <div id="start-of-content" class="accessibility-aid"></div>

      <div id="js-flash-container">
</div>


    <div role="main" class="main-content">
        <div itemscope itemtype="http://schema.org/WebPage">
    <div id="js-repo-pjax-container" class="context-loader-container js-repo-nav-next" data-pjax-container>
      
<div class="pagehead repohead instapaper_ignore readability-menu experiment-repo-nav">
  <div class="container repohead-details-container">

    

<ul class="pagehead-actions">

  <li>
        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/notifications/subscribe" class="js-social-container" data-autosubmit="true" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="y0wWB998f3sVv50V8bpDkOM5N+cpwPMluHv/c6MzxiBGP9EPz2SukeMvR8XwWOVBY4j96+Cd1P4wnGrtkGm+hg==" /></div>      <input id="repository_id" name="repository_id" type="hidden" value="48056280" />

        <div class="select-menu js-menu-container js-select-menu">
          <a href="/archeg/ScalaPlay/subscription"
            class="btn btn-sm btn-with-count select-menu-button js-menu-target" role="button" tabindex="0" aria-haspopup="true"
            data-ga-click="Repository, click Watch settings, action:blob#show">
            <span class="js-select-button">
              <span class="octicon octicon-eye"></span>
              Unwatch
            </span>
          </a>
          <a class="social-count js-social-count" href="/archeg/ScalaPlay/watchers">
            1
          </a>

        <div class="select-menu-modal-holder">
          <div class="select-menu-modal subscription-menu-modal js-menu-content" aria-hidden="true">
            <div class="select-menu-header">
              <span class="octicon octicon-x js-menu-close" role="button" aria-label="Close"></span>
              <span class="select-menu-title">Notifications</span>
            </div>

              <div class="select-menu-list js-navigation-container" role="menu">

                <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <div class="select-menu-item-text">
                    <input id="do_included" name="do" type="radio" value="included" />
                    <span class="select-menu-item-heading">Not watching</span>
                    <span class="description">Be notified when participating or @mentioned.</span>
                    <span class="js-select-button-text hidden-select-button-text">
                      <span class="octicon octicon-eye"></span>
                      Watch
                    </span>
                  </div>
                </div>

                <div class="select-menu-item js-navigation-item selected" role="menuitem" tabindex="0">
                  <span class="select-menu-item-icon octicon octicon octicon-check"></span>
                  <div class="select-menu-item-text">
                    <input checked="checked" id="do_subscribed" name="do" type="radio" value="subscribed" />
                    <span class="select-menu-item-heading">Watching</span>
                    <span class="description">Be notified of all conversations.</span>
                    <span class="js-select-button-text hidden-select-button-text">
                      <span class="octicon octicon-eye"></span>
                      Unwatch
                    </span>
                  </div>
                </div>

                <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <div class="select-menu-item-text">
                    <input id="do_ignore" name="do" type="radio" value="ignore" />
                    <span class="select-menu-item-heading">Ignoring</span>
                    <span class="description">Never be notified.</span>
                    <span class="js-select-button-text hidden-select-button-text">
                      <span class="octicon octicon-mute"></span>
                      Stop ignoring
                    </span>
                  </div>
                </div>

              </div>

            </div>
          </div>
        </div>
</form>
  </li>

  <li>
    
  <div class="js-toggler-container js-social-container starring-container ">

    <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/unstar" class="js-toggler-form starred js-unstar-button" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="Dgp3zf/7qNTVUeC4uNxSeHy5OsALD4LFKPGSoLIbasQt0EOnT7Dl9Kx8L5kabGiEaAFBJT6sdmhbjNZgR1JsHA==" /></div>
      <button
        class="btn btn-sm btn-with-count js-toggler-target"
        aria-label="Unstar this repository" title="Unstar archeg/ScalaPlay"
        data-ga-click="Repository, click unstar button, action:blob#show; text:Unstar">
        <span class="octicon octicon-star"></span>
        Unstar
      </button>
        <a class="social-count js-social-count" href="/archeg/ScalaPlay/stargazers">
          0
        </a>
</form>
    <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/star" class="js-toggler-form unstarred js-star-button" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="GHE7jaKGYD47uZGj8x98EGPBPBaXVWP+xF2/jHhpwwF8Pvb0rHwAPHyMdCAC+0xlHyHdSQKuzIjR3kCyZJnnKw==" /></div>
      <button
        class="btn btn-sm btn-with-count js-toggler-target"
        aria-label="Star this repository" title="Star archeg/ScalaPlay"
        data-ga-click="Repository, click star button, action:blob#show; text:Star">
        <span class="octicon octicon-star"></span>
        Star
      </button>
        <a class="social-count js-social-count" href="/archeg/ScalaPlay/stargazers">
          0
        </a>
</form>  </div>

  </li>

  <li>
          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/fork" class="btn-with-count" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="WdjMvvEyUlAmmI+zytHjZx2b/BRLU8rH2r2hos57HdJ/CcTg8pntbHA5Kernr+VaMwuyj0Fz9bSwpiYXfsnXwg==" /></div>
            <button
                type="submit"
                class="btn btn-sm btn-with-count"
                data-ga-click="Repository, show fork modal, action:blob#show; text:Fork"
                title="Fork your own copy of archeg/ScalaPlay to your account"
                aria-label="Fork your own copy of archeg/ScalaPlay to your account">
              <span class="octicon octicon-repo-forked"></span>
              Fork
            </button>
</form>
    <a href="/archeg/ScalaPlay/network" class="social-count">
      0
    </a>
  </li>
</ul>

    <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title public ">
  <span class="octicon octicon-repo"></span>
  <span class="author"><a href="/archeg" class="url fn" itemprop="url" rel="author"><span itemprop="title">archeg</span></a></span><!--
--><span class="path-divider">/</span><!--
--><strong><a href="/archeg/ScalaPlay" data-pjax="#js-repo-pjax-container">ScalaPlay</a></strong>

  <span class="page-context-loader">
    <img alt="" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32.gif" width="16" />
  </span>

</h1>

  </div>
  <div class="container">
    
<nav class="reponav js-repo-nav js-sidenav-container-pjax js-octicon-loaders"
     role="navigation"
     data-pjax="#js-repo-pjax-container">

  <a href="/archeg/ScalaPlay" aria-label="Code" aria-selected="true" class="js-selected-navigation-item selected reponav-item" data-hotkey="g c" data-selected-links="repo_source repo_downloads repo_commits repo_releases repo_tags repo_branches /archeg/ScalaPlay">
    <span class="octicon octicon-code"></span>
    Code
</a>
    <a href="/archeg/ScalaPlay/issues" class="js-selected-navigation-item reponav-item" data-hotkey="g i" data-selected-links="repo_issues repo_labels repo_milestones /archeg/ScalaPlay/issues">
      <span class="octicon octicon-issue-opened"></span>
      Issues
      <span class="counter">0</span>
</a>
  <a href="/archeg/ScalaPlay/pulls" class="js-selected-navigation-item reponav-item" data-hotkey="g p" data-selected-links="repo_pulls /archeg/ScalaPlay/pulls">
    <span class="octicon octicon-git-pull-request"></span>
    Pull requests
    <span class="counter">0</span>
</a>
    <a href="/archeg/ScalaPlay/wiki" class="js-selected-navigation-item reponav-item" data-hotkey="g w" data-selected-links="repo_wiki /archeg/ScalaPlay/wiki">
      <span class="octicon octicon-book"></span>
      Wiki
</a>
  <a href="/archeg/ScalaPlay/pulse" class="js-selected-navigation-item reponav-item" data-selected-links="pulse /archeg/ScalaPlay/pulse">
    <span class="octicon octicon-pulse"></span>
    Pulse
</a>
  <a href="/archeg/ScalaPlay/graphs" class="js-selected-navigation-item reponav-item" data-selected-links="repo_graphs repo_contributors /archeg/ScalaPlay/graphs">
    <span class="octicon octicon-graph"></span>
    Graphs
</a>
    <a href="/archeg/ScalaPlay/settings" class="js-selected-navigation-item reponav-item" data-selected-links="repo_settings repo_branch_settings hooks /archeg/ScalaPlay/settings">
      <span class="octicon octicon-gear"></span>
      Settings
</a>
</nav>

  </div>
</div>

<div class="container new-discussion-timeline experiment-repo-nav">
  <div class="repository-content">

    

<a href="/archeg/ScalaPlay/blob/3e975fc4e13904bcb93b66fe4b239a9a6aeeb7e3/ninetyNineScalaProblems/src/main/scala/LogicAndCodes46_50.scala" class="hidden js-permalink-shortcut" data-hotkey="y">Permalink</a>

<!-- blob contrib key: blob_contributors:v21:3a3289e86131f4721117978d879b2f2e -->

<div class="file-navigation js-zeroclipboard-container">
  
<div class="select-menu js-menu-container js-select-menu left">
  <button class="btn btn-sm select-menu-button js-menu-target css-truncate" data-hotkey="w"
    title="master"
    type="button" aria-label="Switch branches or tags" tabindex="0" aria-haspopup="true">
    <i>Branch:</i>
    <span class="js-select-button css-truncate-target">master</span>
  </button>

  <div class="select-menu-modal-holder js-menu-content js-navigation-container" data-pjax aria-hidden="true">

    <div class="select-menu-modal">
      <div class="select-menu-header">
        <span class="octicon octicon-x js-menu-close" role="button" aria-label="Close"></span>
        <span class="select-menu-title">Switch branches/tags</span>
      </div>

      <div class="select-menu-filters">
        <div class="select-menu-text-filter">
          <input type="text" aria-label="Find or create a branch…" id="context-commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Find or create a branch…">
        </div>
        <div class="select-menu-tabs">
          <ul>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="branches" data-filter-placeholder="Find or create a branch…" class="js-select-menu-tab" role="tab">Branches</a>
            </li>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="tags" data-filter-placeholder="Find a tag…" class="js-select-menu-tab" role="tab">Tags</a>
            </li>
          </ul>
        </div>
      </div>

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="branches" role="menu">

        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <a class="select-menu-item js-navigation-item js-navigation-open selected"
               href="/archeg/ScalaPlay/blob/master/ninetyNineScalaProblems/src/main/scala/LogicAndCodes46_50.scala"
               data-name="master"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="master">
                master
              </span>
            </a>
        </div>

          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/branches" class="js-create-branch select-menu-item select-menu-new-item-form js-navigation-item js-new-item-form" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="F9cKppmJLZ5QJcV+HjQ5hhKCKcLnfAMaq6GJPslFviZldECIE2BkXh5vPJXodnSbNPqx8jh0C1jnEKrQdHOKKg==" /></div>
            <span class="octicon octicon-git-branch select-menu-item-icon"></span>
            <div class="select-menu-item-text">
              <span class="select-menu-item-heading">Create branch: <span class="js-new-item-name"></span></span>
              <span class="description">from ‘master’</span>
            </div>
            <input type="hidden" name="name" id="name" class="js-new-item-value">
            <input type="hidden" name="branch" id="branch" value="master">
            <input type="hidden" name="path" id="path" value="ninetyNineScalaProblems/src/main/scala/LogicAndCodes46_50.scala">
</form>
      </div>

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="tags">
        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


        </div>

        <div class="select-menu-no-results">Nothing to show</div>
      </div>

    </div>
  </div>
</div>

  <div class="btn-group right">
    <a href="/archeg/ScalaPlay/find/master"
          class="js-show-file-finder btn btn-sm"
          data-pjax
          data-hotkey="t">
      Find file
    </a>
    <button aria-label="Copy file path to clipboard" class="js-zeroclipboard btn btn-sm zeroclipboard-button tooltipped tooltipped-s" data-copied-hint="Copied!" type="button">Copy path</button>
  </div>
  <div class="breadcrumb js-zeroclipboard-target">
    <span class="repo-root js-repo-root"><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">ScalaPlay</span></a></span></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">ninetyNineScalaProblems</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems/src" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">src</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems/src/main" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">main</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems/src/main/scala" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">scala</span></a></span><span class="separator">/</span><strong class="final-path">LogicAndCodes46_50.scala</strong>
  </div>
</div>

<include-fragment class="commit-tease" src="/archeg/ScalaPlay/contributors/master/ninetyNineScalaProblems/src/main/scala/LogicAndCodes46_50.scala">
  <div>
    Fetching contributors&hellip;
  </div>

  <div class="commit-tease-contributors">
    <img alt="" class="loader-loading left" height="16" src="https://assets-cdn.github.com/images/spinners/octocat-spinner-32-EAF2F5.gif" width="16" />
    <span class="loader-error">Cannot retrieve contributors at this time</span>
  </div>
</include-fragment>
<div class="file">
  <div class="file-header">
  <div class="file-actions">

    <div class="btn-group">
      <a href="/archeg/ScalaPlay/raw/master/ninetyNineScalaProblems/src/main/scala/LogicAndCodes46_50.scala" class="btn btn-sm " id="raw-url">Raw</a>
        <a href="/archeg/ScalaPlay/blame/master/ninetyNineScalaProblems/src/main/scala/LogicAndCodes46_50.scala" class="btn btn-sm js-update-url-with-hash">Blame</a>
      <a href="/archeg/ScalaPlay/commits/master/ninetyNineScalaProblems/src/main/scala/LogicAndCodes46_50.scala" class="btn btn-sm " rel="nofollow">History</a>
    </div>

        <a class="octicon-btn tooltipped tooltipped-nw"
           href="github-windows://openRepo/https://github.com/archeg/ScalaPlay?branch=master&amp;filepath=ninetyNineScalaProblems%2Fsrc%2Fmain%2Fscala%2FLogicAndCodes46_50.scala"
           aria-label="Open this file in GitHub Desktop"
           data-ga-click="Repository, open with desktop, type:windows">
            <span class="octicon octicon-device-desktop"></span>
        </a>

        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/edit/master/ninetyNineScalaProblems/src/main/scala/LogicAndCodes46_50.scala" class="inline-form js-update-url-with-hash" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="R02RxkXZsZ9Vg8AlLpS6e8+U1mk58vAK2V6kFYHnCSOAROJWQ5q6uzGvKXKQACKV6IKiDpBrWyLx48CfrP7qdA==" /></div>
          <button class="octicon-btn tooltipped tooltipped-nw" type="submit"
            aria-label="Edit this file" data-hotkey="e" data-disable-with>
            <span class="octicon octicon-pencil"></span>
          </button>
</form>        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/delete/master/ninetyNineScalaProblems/src/main/scala/LogicAndCodes46_50.scala" class="inline-form" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="WMI25Bm0h6j6mmdQdTW0ZtEa2q13/91HrpsJAVre+dBtOL54xwg6Czd78POhrfMbV9TNiPrBxPW1xQcmrMOjHQ==" /></div>
          <button class="octicon-btn octicon-btn-danger tooltipped tooltipped-nw" type="submit"
            aria-label="Delete this file" data-disable-with>
            <span class="octicon octicon-trashcan"></span>
          </button>
</form>  </div>

  <div class="file-info">
      138 lines (111 sloc)
      <span class="file-info-divider"></span>
    4.36 KB
  </div>
</div>

  

  <div class="blob-wrapper data type-scala">
      <table class="highlight tab-size js-file-line-container" data-tab-size="8">
      <tr>
        <td id="L1" class="blob-num js-line-number" data-line-number="1"></td>
        <td id="LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c">/*</span></td>
      </tr>
      <tr>
        <td id="L2" class="blob-num js-line-number" data-line-number="2"></td>
        <td id="LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-c"> * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)</span></td>
      </tr>
      <tr>
        <td id="L3" class="blob-num js-line-number" data-line-number="3"></td>
        <td id="LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-c"> */</span></td>
      </tr>
      <tr>
        <td id="L4" class="blob-num js-line-number" data-line-number="4"></td>
        <td id="LC4" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L5" class="blob-num js-line-number" data-line-number="5"></td>
        <td id="LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-k">package</span> <span class="pl-en">NinetyNineScalaProblem</span></td>
      </tr>
      <tr>
        <td id="L6" class="blob-num js-line-number" data-line-number="6"></td>
        <td id="LC6" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L7" class="blob-num js-line-number" data-line-number="7"></td>
        <td id="LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-v">CommonPlay.</span><span class="pl-v">ChapterApp</span></td>
      </tr>
      <tr>
        <td id="L8" class="blob-num js-line-number" data-line-number="8"></td>
        <td id="LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-v">scala.collection.</span><span class="pl-v">_</span></td>
      </tr>
      <tr>
        <td id="L9" class="blob-num js-line-number" data-line-number="9"></td>
        <td id="LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-v">scala.collection.immutable.</span><span class="pl-v">HashMap</span></td>
      </tr>
      <tr>
        <td id="L10" class="blob-num js-line-number" data-line-number="10"></td>
        <td id="LC10" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L11" class="blob-num js-line-number" data-line-number="11"></td>
        <td id="LC11" class="blob-code blob-code-inner js-file-line"><span class="pl-c">/**</span></td>
      </tr>
      <tr>
        <td id="L12" class="blob-num js-line-number" data-line-number="12"></td>
        <td id="LC12" class="blob-code blob-code-inner js-file-line"><span class="pl-c">  * Created by archeg on 11/7/2015.</span></td>
      </tr>
      <tr>
        <td id="L13" class="blob-num js-line-number" data-line-number="13"></td>
        <td id="LC13" class="blob-code blob-code-inner js-file-line"><span class="pl-c">  */</span></td>
      </tr>
      <tr>
        <td id="L14" class="blob-num js-line-number" data-line-number="14"></td>
        <td id="LC14" class="blob-code blob-code-inner js-file-line"><span class="pl-k">object</span> <span class="pl-en">LogicAndCodes46_50</span> <span class="pl-k">extends</span> <span class="pl-e">ChapterApp</span> {</td>
      </tr>
      <tr>
        <td id="L15" class="blob-num js-line-number" data-line-number="15"></td>
        <td id="LC15" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P46. Truth tables for logical expressions.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L16" class="blob-num js-line-number" data-line-number="16"></td>
        <td id="LC16" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">and</span>(<span class="pl-v">a</span>: <span class="pl-k">Boolean</span>, <span class="pl-v">b</span>: <span class="pl-k">Boolean</span>) <span class="pl-k">=</span> (a, b) <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L17" class="blob-num js-line-number" data-line-number="17"></td>
        <td id="LC17" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> (<span class="pl-c1">true</span>, <span class="pl-c1">true</span>) <span class="pl-k">=&gt;</span> <span class="pl-c1">true</span></td>
      </tr>
      <tr>
        <td id="L18" class="blob-num js-line-number" data-line-number="18"></td>
        <td id="LC18" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> _ <span class="pl-k">=&gt;</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L19" class="blob-num js-line-number" data-line-number="19"></td>
        <td id="LC19" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L20" class="blob-num js-line-number" data-line-number="20"></td>
        <td id="LC20" class="blob-code blob-code-inner js-file-line">  check(and, _ &amp; _)</td>
      </tr>
      <tr>
        <td id="L21" class="blob-num js-line-number" data-line-number="21"></td>
        <td id="LC21" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L22" class="blob-num js-line-number" data-line-number="22"></td>
        <td id="LC22" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">or</span>(<span class="pl-v">a</span>: <span class="pl-k">Boolean</span>, <span class="pl-v">b</span>: <span class="pl-k">Boolean</span>) <span class="pl-k">=</span> (a, b) <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L23" class="blob-num js-line-number" data-line-number="23"></td>
        <td id="LC23" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> (<span class="pl-c1">false</span>, <span class="pl-c1">false</span>) <span class="pl-k">=&gt;</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L24" class="blob-num js-line-number" data-line-number="24"></td>
        <td id="LC24" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> _ <span class="pl-k">=&gt;</span> <span class="pl-c1">true</span></td>
      </tr>
      <tr>
        <td id="L25" class="blob-num js-line-number" data-line-number="25"></td>
        <td id="LC25" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L26" class="blob-num js-line-number" data-line-number="26"></td>
        <td id="LC26" class="blob-code blob-code-inner js-file-line">  check(or, _ <span class="pl-k">|</span> _)</td>
      </tr>
      <tr>
        <td id="L27" class="blob-num js-line-number" data-line-number="27"></td>
        <td id="LC27" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L28" class="blob-num js-line-number" data-line-number="28"></td>
        <td id="LC28" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">xor</span>(<span class="pl-v">a</span>: <span class="pl-k">Boolean</span>, <span class="pl-v">b</span>: <span class="pl-k">Boolean</span>) <span class="pl-k">=</span> a <span class="pl-k">!=</span> b</td>
      </tr>
      <tr>
        <td id="L29" class="blob-num js-line-number" data-line-number="29"></td>
        <td id="LC29" class="blob-code blob-code-inner js-file-line">  check(xor, _ ^ _)</td>
      </tr>
      <tr>
        <td id="L30" class="blob-num js-line-number" data-line-number="30"></td>
        <td id="LC30" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">not</span>(<span class="pl-v">a</span>: <span class="pl-k">Boolean</span>) <span class="pl-k">=</span> a <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L31" class="blob-num js-line-number" data-line-number="31"></td>
        <td id="LC31" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-c1">true</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L32" class="blob-num js-line-number" data-line-number="32"></td>
        <td id="LC32" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-c1">false</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">true</span></td>
      </tr>
      <tr>
        <td id="L33" class="blob-num js-line-number" data-line-number="33"></td>
        <td id="LC33" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L34" class="blob-num js-line-number" data-line-number="34"></td>
        <td id="LC34" class="blob-code blob-code-inner js-file-line">  check(not _, <span class="pl-k">!</span>_)</td>
      </tr>
      <tr>
        <td id="L35" class="blob-num js-line-number" data-line-number="35"></td>
        <td id="LC35" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L36" class="blob-num js-line-number" data-line-number="36"></td>
        <td id="LC36" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">nand</span>(<span class="pl-v">a</span>: <span class="pl-k">Boolean</span>, <span class="pl-v">b</span>: <span class="pl-k">Boolean</span>) <span class="pl-k">=</span> not(and(a, b))</td>
      </tr>
      <tr>
        <td id="L37" class="blob-num js-line-number" data-line-number="37"></td>
        <td id="LC37" class="blob-code blob-code-inner js-file-line">  check(nand, (x, y) <span class="pl-k">=&gt;</span> <span class="pl-k">!</span>(x &amp; y))</td>
      </tr>
      <tr>
        <td id="L38" class="blob-num js-line-number" data-line-number="38"></td>
        <td id="LC38" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">nor</span>(<span class="pl-v">a</span>: <span class="pl-k">Boolean</span>, <span class="pl-v">b</span>: <span class="pl-k">Boolean</span>) <span class="pl-k">=</span> not(or(a, b))</td>
      </tr>
      <tr>
        <td id="L39" class="blob-num js-line-number" data-line-number="39"></td>
        <td id="LC39" class="blob-code blob-code-inner js-file-line">  check(nor, (x, y) <span class="pl-k">=&gt;</span> <span class="pl-k">!</span>(x <span class="pl-k">|</span> y))</td>
      </tr>
      <tr>
        <td id="L40" class="blob-num js-line-number" data-line-number="40"></td>
        <td id="LC40" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">impl</span>(<span class="pl-v">a</span>: <span class="pl-k">Boolean</span>, <span class="pl-v">b</span>: <span class="pl-k">Boolean</span>) <span class="pl-k">=</span> or(not(a), b)</td>
      </tr>
      <tr>
        <td id="L41" class="blob-num js-line-number" data-line-number="41"></td>
        <td id="LC41" class="blob-code blob-code-inner js-file-line">  check(impl, <span class="pl-k">!</span>_ <span class="pl-k">|</span> _)</td>
      </tr>
      <tr>
        <td id="L42" class="blob-num js-line-number" data-line-number="42"></td>
        <td id="LC42" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L43" class="blob-num js-line-number" data-line-number="43"></td>
        <td id="LC43" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">check</span>(<span class="pl-v">a1</span>: (<span class="pl-k">Boolean</span>, <span class="pl-k">Boolean</span>) <span class="pl-k">=&gt;</span> <span class="pl-k">Boolean</span>, <span class="pl-v">a2</span>: (<span class="pl-k">Boolean</span>, <span class="pl-k">Boolean</span>) <span class="pl-k">=&gt;</span> <span class="pl-k">Boolean</span>)<span class="pl-k">:</span> <span class="pl-k">Unit</span> <span class="pl-k">=</span>  {</td>
      </tr>
      <tr>
        <td id="L44" class="blob-num js-line-number" data-line-number="44"></td>
        <td id="LC44" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">for</span> (first <span class="pl-k">&lt;</span><span class="pl-k">-</span> <span class="pl-en">List</span>(<span class="pl-c1">true</span>, <span class="pl-c1">false</span>);</td>
      </tr>
      <tr>
        <td id="L45" class="blob-num js-line-number" data-line-number="45"></td>
        <td id="LC45" class="blob-code blob-code-inner js-file-line">         second <span class="pl-k">&lt;</span><span class="pl-k">-</span> <span class="pl-en">List</span>(<span class="pl-c1">true</span>, <span class="pl-c1">false</span>)) {</td>
      </tr>
      <tr>
        <td id="L46" class="blob-num js-line-number" data-line-number="46"></td>
        <td id="LC46" class="blob-code blob-code-inner js-file-line">      assert(a1(first, second) <span class="pl-k">==</span> a2(first, second), s<span class="pl-s"><span class="pl-pds">&quot;</span>$a1 and $a2 failed at ($first, $second)<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L47" class="blob-num js-line-number" data-line-number="47"></td>
        <td id="LC47" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L48" class="blob-num js-line-number" data-line-number="48"></td>
        <td id="LC48" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L49" class="blob-num js-line-number" data-line-number="49"></td>
        <td id="LC49" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L50" class="blob-num js-line-number" data-line-number="50"></td>
        <td id="LC50" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">check</span>(<span class="pl-v">a1</span>: <span class="pl-k">Boolean</span> <span class="pl-k">=&gt;</span> <span class="pl-k">Boolean</span>, <span class="pl-v">a2</span>: <span class="pl-k">Boolean</span> <span class="pl-k">=&gt;</span> <span class="pl-k">Boolean</span>)<span class="pl-k">:</span> <span class="pl-k">Unit</span> <span class="pl-k">=</span>  {</td>
      </tr>
      <tr>
        <td id="L51" class="blob-num js-line-number" data-line-number="51"></td>
        <td id="LC51" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">for</span> (first <span class="pl-k">&lt;</span><span class="pl-k">-</span> <span class="pl-en">List</span>(<span class="pl-c1">true</span>, <span class="pl-c1">false</span>)) {</td>
      </tr>
      <tr>
        <td id="L52" class="blob-num js-line-number" data-line-number="52"></td>
        <td id="LC52" class="blob-code blob-code-inner js-file-line">      assert(a1(first) <span class="pl-k">==</span> a2(first), s<span class="pl-s"><span class="pl-pds">&quot;</span>$a1 and $a2 failed at ($first)<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L53" class="blob-num js-line-number" data-line-number="53"></td>
        <td id="LC53" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L54" class="blob-num js-line-number" data-line-number="54"></td>
        <td id="LC54" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L55" class="blob-num js-line-number" data-line-number="55"></td>
        <td id="LC55" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L56" class="blob-num js-line-number" data-line-number="56"></td>
        <td id="LC56" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">table2</span>(<span class="pl-v">f</span>: (<span class="pl-k">Boolean</span>, <span class="pl-k">Boolean</span>) <span class="pl-k">=&gt;</span> <span class="pl-k">Boolean</span>)<span class="pl-k">:</span> <span class="pl-k">Unit</span> <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L57" class="blob-num js-line-number" data-line-number="57"></td>
        <td id="LC57" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">for</span> (a <span class="pl-k">&lt;</span><span class="pl-k">-</span> <span class="pl-en">List</span>(<span class="pl-c1">true</span>, <span class="pl-c1">false</span>);</td>
      </tr>
      <tr>
        <td id="L58" class="blob-num js-line-number" data-line-number="58"></td>
        <td id="LC58" class="blob-code blob-code-inner js-file-line">    b <span class="pl-k">&lt;</span><span class="pl-k">-</span> <span class="pl-en">List</span>(<span class="pl-c1">true</span>, <span class="pl-c1">false</span>)) {</td>
      </tr>
      <tr>
        <td id="L59" class="blob-num js-line-number" data-line-number="59"></td>
        <td id="LC59" class="blob-code blob-code-inner js-file-line">      printf(<span class="pl-s"><span class="pl-pds">&quot;</span>%-5s %-5s %-5s<span class="pl-cce">\n</span><span class="pl-pds">&quot;</span></span>, a, b, f(a, b))}</td>
      </tr>
      <tr>
        <td id="L60" class="blob-num js-line-number" data-line-number="60"></td>
        <td id="LC60" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L61" class="blob-num js-line-number" data-line-number="61"></td>
        <td id="LC61" class="blob-code blob-code-inner js-file-line">  table2(and)</td>
      </tr>
      <tr>
        <td id="L62" class="blob-num js-line-number" data-line-number="62"></td>
        <td id="LC62" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L63" class="blob-num js-line-number" data-line-number="63"></td>
        <td id="LC63" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P47. Truth tables for logical expressions.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L64" class="blob-num js-line-number" data-line-number="64"></td>
        <td id="LC64" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">implicit</span> <span class="pl-k">class</span> <span class="pl-en">BoolToLogicalOp</span>(<span class="pl-k">val</span> <span class="pl-en">a</span><span class="pl-k">:</span> <span class="pl-k">Boolean</span>) {</td>
      </tr>
      <tr>
        <td id="L65" class="blob-num js-line-number" data-line-number="65"></td>
        <td id="LC65" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">or</span>(<span class="pl-v">b</span>: <span class="pl-k">Boolean</span>) <span class="pl-k">=</span> a <span class="pl-k">|</span> b</td>
      </tr>
      <tr>
        <td id="L66" class="blob-num js-line-number" data-line-number="66"></td>
        <td id="LC66" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">xor</span>(<span class="pl-v">b</span>: <span class="pl-k">Boolean</span>) <span class="pl-k">=</span> a ^ b</td>
      </tr>
      <tr>
        <td id="L67" class="blob-num js-line-number" data-line-number="67"></td>
        <td id="LC67" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">and</span>(<span class="pl-v">b</span>: <span class="pl-k">Boolean</span>) <span class="pl-k">=</span> a &amp; b</td>
      </tr>
      <tr>
        <td id="L68" class="blob-num js-line-number" data-line-number="68"></td>
        <td id="LC68" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L69" class="blob-num js-line-number" data-line-number="69"></td>
        <td id="LC69" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L70" class="blob-num js-line-number" data-line-number="70"></td>
        <td id="LC70" class="blob-code blob-code-inner js-file-line">  out(<span class="pl-c1">true</span> and <span class="pl-c1">true</span>) <span class="pl-k">===</span> <span class="pl-c1">true</span></td>
      </tr>
      <tr>
        <td id="L71" class="blob-num js-line-number" data-line-number="71"></td>
        <td id="LC71" class="blob-code blob-code-inner js-file-line">  out(<span class="pl-c1">true</span> and <span class="pl-c1">false</span>) <span class="pl-k">===</span> <span class="pl-c1">false</span></td>
      </tr>
      <tr>
        <td id="L72" class="blob-num js-line-number" data-line-number="72"></td>
        <td id="LC72" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L73" class="blob-num js-line-number" data-line-number="73"></td>
        <td id="LC73" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P48.....<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L74" class="blob-num js-line-number" data-line-number="74"></td>
        <td id="LC74" class="blob-code blob-code-inner js-file-line">  out(<span class="pl-c1">true</span> and (<span class="pl-c1">true</span> or <span class="pl-c1">false</span>)) <span class="pl-k">===</span> <span class="pl-c1">true</span></td>
      </tr>
      <tr>
        <td id="L75" class="blob-num js-line-number" data-line-number="75"></td>
        <td id="LC75" class="blob-code blob-code-inner js-file-line">  out(<span class="pl-c1">true</span> and <span class="pl-c1">true</span> and <span class="pl-c1">true</span>) <span class="pl-k">===</span> <span class="pl-c1">true</span></td>
      </tr>
      <tr>
        <td id="L76" class="blob-num js-line-number" data-line-number="76"></td>
        <td id="LC76" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L77" class="blob-num js-line-number" data-line-number="77"></td>
        <td id="LC77" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P49. Gray code.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L78" class="blob-num js-line-number" data-line-number="78"></td>
        <td id="LC78" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p49</span>(<span class="pl-v">n</span>: <span class="pl-k">Int</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-k">String</span>] <span class="pl-k">=</span> n <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L79" class="blob-num js-line-number" data-line-number="79"></td>
        <td id="LC79" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-c1">1</span> <span class="pl-k">=&gt;</span> <span class="pl-en">List</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>0<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>1<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L80" class="blob-num js-line-number" data-line-number="80"></td>
        <td id="LC80" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> x <span class="pl-k">=&gt;</span> (p49(x <span class="pl-k">-</span> <span class="pl-c1">1</span>) map { <span class="pl-s"><span class="pl-pds">&quot;</span>0<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> _ }) <span class="pl-k">:::</span> (p49(x <span class="pl-k">-</span> <span class="pl-c1">1</span>).reverse map { <span class="pl-s"><span class="pl-pds">&quot;</span>1<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> _ })</td>
      </tr>
      <tr>
        <td id="L81" class="blob-num js-line-number" data-line-number="81"></td>
        <td id="LC81" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L82" class="blob-num js-line-number" data-line-number="82"></td>
        <td id="LC82" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L83" class="blob-num js-line-number" data-line-number="83"></td>
        <td id="LC83" class="blob-code blob-code-inner js-file-line">  out(p49(<span class="pl-c1">1</span>)) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>0<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>1<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L84" class="blob-num js-line-number" data-line-number="84"></td>
        <td id="LC84" class="blob-code blob-code-inner js-file-line">  out(p49(<span class="pl-c1">2</span>)) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>00<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>01<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>11<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>10<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L85" class="blob-num js-line-number" data-line-number="85"></td>
        <td id="LC85" class="blob-code blob-code-inner js-file-line">  out(p49(<span class="pl-c1">3</span>)) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>000<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>001<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>011<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>010<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>110<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>111<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>101<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>100<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L86" class="blob-num js-line-number" data-line-number="86"></td>
        <td id="LC86" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L87" class="blob-num js-line-number" data-line-number="87"></td>
        <td id="LC87" class="blob-code blob-code-inner js-file-line">  <span class="pl-c">// memoized</span></td>
      </tr>
      <tr>
        <td id="L88" class="blob-num js-line-number" data-line-number="88"></td>
        <td id="LC88" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p49_2</span>(<span class="pl-v">n</span>: <span class="pl-k">Int</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-k">String</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L89" class="blob-num js-line-number" data-line-number="89"></td>
        <td id="LC89" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">memoized</span> <span class="pl-k">=</span> mutable.<span class="pl-en">Map</span>[<span class="pl-k">Int</span>, <span class="pl-en">List</span>[<span class="pl-k">String</span>]]()</td>
      </tr>
      <tr>
        <td id="L90" class="blob-num js-line-number" data-line-number="90"></td>
        <td id="LC90" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L91" class="blob-num js-line-number" data-line-number="91"></td>
        <td id="LC91" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">compute</span>(<span class="pl-v">n</span>: <span class="pl-k">Int</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-k">String</span>] <span class="pl-k">=</span> memoized.getOrElseUpdate(n, n <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L92" class="blob-num js-line-number" data-line-number="92"></td>
        <td id="LC92" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-c1">1</span> <span class="pl-k">=&gt;</span> <span class="pl-en">List</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>0<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>1<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L93" class="blob-num js-line-number" data-line-number="93"></td>
        <td id="LC93" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> x <span class="pl-k">=&gt;</span> (compute(x <span class="pl-k">-</span> <span class="pl-c1">1</span>) map {<span class="pl-s"><span class="pl-pds">&quot;</span>0<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> _}) <span class="pl-k">:::</span> (compute(x <span class="pl-k">-</span> <span class="pl-c1">1</span>).reverse map {<span class="pl-s"><span class="pl-pds">&quot;</span>1<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> _})</td>
      </tr>
      <tr>
        <td id="L94" class="blob-num js-line-number" data-line-number="94"></td>
        <td id="LC94" class="blob-code blob-code-inner js-file-line">    })</td>
      </tr>
      <tr>
        <td id="L95" class="blob-num js-line-number" data-line-number="95"></td>
        <td id="LC95" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L96" class="blob-num js-line-number" data-line-number="96"></td>
        <td id="LC96" class="blob-code blob-code-inner js-file-line">    compute(n)</td>
      </tr>
      <tr>
        <td id="L97" class="blob-num js-line-number" data-line-number="97"></td>
        <td id="LC97" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L98" class="blob-num js-line-number" data-line-number="98"></td>
        <td id="LC98" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L99" class="blob-num js-line-number" data-line-number="99"></td>
        <td id="LC99" class="blob-code blob-code-inner js-file-line">  out(p49_2(<span class="pl-c1">1</span>)) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>0<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>1<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L100" class="blob-num js-line-number" data-line-number="100"></td>
        <td id="LC100" class="blob-code blob-code-inner js-file-line">  out(p49_2(<span class="pl-c1">2</span>)) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>00<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>01<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>11<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>10<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L101" class="blob-num js-line-number" data-line-number="101"></td>
        <td id="LC101" class="blob-code blob-code-inner js-file-line">  out(p49_2(<span class="pl-c1">3</span>)) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>000<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>001<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>011<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>010<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>110<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>111<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>101<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>100<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L102" class="blob-num js-line-number" data-line-number="102"></td>
        <td id="LC102" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L103" class="blob-num js-line-number" data-line-number="103"></td>
        <td id="LC103" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">var</span> <span class="pl-en">size</span> <span class="pl-k">=</span> <span class="pl-c1">18</span></td>
      </tr>
      <tr>
        <td id="L104" class="blob-num js-line-number" data-line-number="104"></td>
        <td id="LC104" class="blob-code blob-code-inner js-file-line">  time(<span class="pl-s"><span class="pl-pds">&quot;</span>Not memoized<span class="pl-pds">&quot;</span></span>) {</td>
      </tr>
      <tr>
        <td id="L105" class="blob-num js-line-number" data-line-number="105"></td>
        <td id="LC105" class="blob-code blob-code-inner js-file-line">    p49(size)</td>
      </tr>
      <tr>
        <td id="L106" class="blob-num js-line-number" data-line-number="106"></td>
        <td id="LC106" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L107" class="blob-num js-line-number" data-line-number="107"></td>
        <td id="LC107" class="blob-code blob-code-inner js-file-line">  time(<span class="pl-s"><span class="pl-pds">&quot;</span>Memoized<span class="pl-pds">&quot;</span></span>) {</td>
      </tr>
      <tr>
        <td id="L108" class="blob-num js-line-number" data-line-number="108"></td>
        <td id="LC108" class="blob-code blob-code-inner js-file-line">    p49_2(size)</td>
      </tr>
      <tr>
        <td id="L109" class="blob-num js-line-number" data-line-number="109"></td>
        <td id="LC109" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L110" class="blob-num js-line-number" data-line-number="110"></td>
        <td id="LC110" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L111" class="blob-num js-line-number" data-line-number="111"></td>
        <td id="LC111" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P50. Huffman code.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L112" class="blob-num js-line-number" data-line-number="112"></td>
        <td id="LC112" class="blob-code blob-code-inner js-file-line">  <span class="pl-c">// Simplest O(n * logn). It requires sorting so this is the most effecient anyway.</span></td>
      </tr>
      <tr>
        <td id="L113" class="blob-num js-line-number" data-line-number="113"></td>
        <td id="LC113" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p50</span>(<span class="pl-v">ls</span>: <span class="pl-en">List</span>[(<span class="pl-k">String</span>, <span class="pl-k">Int</span>)])<span class="pl-k">:</span> <span class="pl-en">List</span>[(<span class="pl-k">String</span>, <span class="pl-k">Int</span>)] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L114" class="blob-num js-line-number" data-line-number="114"></td>
        <td id="LC114" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">abstract</span> <span class="pl-k">class</span> <span class="pl-en">BaseNode</span>(<span class="pl-k">val</span> <span class="pl-en">weight</span><span class="pl-k">:</span> <span class="pl-k">Int</span>)</td>
      </tr>
      <tr>
        <td id="L115" class="blob-num js-line-number" data-line-number="115"></td>
        <td id="LC115" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-k">class</span> <span class="pl-en">Element</span>(<span class="pl-v">symbol</span>: <span class="pl-k">String</span>, <span class="pl-k">override</span> <span class="pl-k">val</span> <span class="pl-en">weight</span><span class="pl-k">:</span> <span class="pl-k">Int</span>) <span class="pl-k">extends</span> <span class="pl-e">BaseNode</span>(weight)</td>
      </tr>
      <tr>
        <td id="L116" class="blob-num js-line-number" data-line-number="116"></td>
        <td id="LC116" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">case</span> <span class="pl-k">class</span> <span class="pl-en">Node</span>(<span class="pl-k">override</span> <span class="pl-k">val</span> <span class="pl-en">weight</span><span class="pl-k">:</span> <span class="pl-k">Int</span>, <span class="pl-v">left</span>: <span class="pl-en">BaseNode</span>, <span class="pl-v">right</span>: <span class="pl-en">BaseNode</span>) <span class="pl-k">extends</span> <span class="pl-e">BaseNode</span>(weight)</td>
      </tr>
      <tr>
        <td id="L117" class="blob-num js-line-number" data-line-number="117"></td>
        <td id="LC117" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L118" class="blob-num js-line-number" data-line-number="118"></td>
        <td id="LC118" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">queue</span> <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-en">mutable.PriorityQueue</span>[<span class="pl-en">BaseNode</span>]()(<span class="pl-en">Ordering</span>.by(x <span class="pl-k">=&gt;</span> <span class="pl-c1">1.0</span> <span class="pl-k">/</span> x.weight))</td>
      </tr>
      <tr>
        <td id="L119" class="blob-num js-line-number" data-line-number="119"></td>
        <td id="LC119" class="blob-code blob-code-inner js-file-line">    queue.enqueue(ls map {<span class="pl-k">case</span> (symb, weight) <span class="pl-k">=&gt;</span> <span class="pl-en">Element</span>(symb, weight)}<span class="pl-k">:</span> _<span class="pl-k">*</span>)</td>
      </tr>
      <tr>
        <td id="L120" class="blob-num js-line-number" data-line-number="120"></td>
        <td id="LC120" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L121" class="blob-num js-line-number" data-line-number="121"></td>
        <td id="LC121" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">while</span> (queue.length <span class="pl-k">&gt;</span> <span class="pl-c1">1</span>) {</td>
      </tr>
      <tr>
        <td id="L122" class="blob-num js-line-number" data-line-number="122"></td>
        <td id="LC122" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">a</span> <span class="pl-k">=</span> queue.dequeue()</td>
      </tr>
      <tr>
        <td id="L123" class="blob-num js-line-number" data-line-number="123"></td>
        <td id="LC123" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">b</span> <span class="pl-k">=</span> queue.dequeue()</td>
      </tr>
      <tr>
        <td id="L124" class="blob-num js-line-number" data-line-number="124"></td>
        <td id="LC124" class="blob-code blob-code-inner js-file-line">      queue.enqueue(<span class="pl-en">Node</span>(a.weight <span class="pl-k">+</span> b.weight, a, b))</td>
      </tr>
      <tr>
        <td id="L125" class="blob-num js-line-number" data-line-number="125"></td>
        <td id="LC125" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L126" class="blob-num js-line-number" data-line-number="126"></td>
        <td id="LC126" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L127" class="blob-num js-line-number" data-line-number="127"></td>
        <td id="LC127" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">unwrap</span>(<span class="pl-v">code</span>: <span class="pl-en">List</span>[<span class="pl-k">Int</span>], <span class="pl-v">node</span>: <span class="pl-en">BaseNode</span>) <span class="pl-k">:</span> <span class="pl-en">List</span>[(<span class="pl-k">String</span>, <span class="pl-en">List</span>[<span class="pl-k">Int</span>])] <span class="pl-k">=</span> {node <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L128" class="blob-num js-line-number" data-line-number="128"></td>
        <td id="LC128" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Element</span>(symbol, _) <span class="pl-k">=&gt;</span> <span class="pl-en">List</span>(symbol <span class="pl-k">-</span><span class="pl-k">&gt;</span> code)</td>
      </tr>
      <tr>
        <td id="L129" class="blob-num js-line-number" data-line-number="129"></td>
        <td id="LC129" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Node</span>(_, left, right) <span class="pl-k">=&gt;</span> unwrap(<span class="pl-c1">0</span> <span class="pl-k">::</span> code, left) <span class="pl-k">:::</span> unwrap(<span class="pl-c1">1</span> <span class="pl-k">::</span> code, right)</td>
      </tr>
      <tr>
        <td id="L130" class="blob-num js-line-number" data-line-number="130"></td>
        <td id="LC130" class="blob-code blob-code-inner js-file-line">    }}</td>
      </tr>
      <tr>
        <td id="L131" class="blob-num js-line-number" data-line-number="131"></td>
        <td id="LC131" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L132" class="blob-num js-line-number" data-line-number="132"></td>
        <td id="LC132" class="blob-code blob-code-inner js-file-line">    unwrap(<span class="pl-c1">Nil</span>, queue.dequeue()) map { <span class="pl-k">case</span> (symbol, code) <span class="pl-k">=&gt;</span> (symbol, code.reverse.foldLeft(<span class="pl-c1">0</span>)((acc, x) <span class="pl-k">=&gt;</span> acc <span class="pl-k">*</span> <span class="pl-c1">10</span> <span class="pl-k">+</span> x))}</td>
      </tr>
      <tr>
        <td id="L133" class="blob-num js-line-number" data-line-number="133"></td>
        <td id="LC133" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L134" class="blob-num js-line-number" data-line-number="134"></td>
        <td id="LC134" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L135" class="blob-num js-line-number" data-line-number="135"></td>
        <td id="LC135" class="blob-code blob-code-inner js-file-line">  out(p50(<span class="pl-en">List</span>((<span class="pl-s"><span class="pl-pds">&quot;</span>a<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">45</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>b<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">13</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>c<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">12</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>d<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">16</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>e<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">9</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>f<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">5</span>))).toSet) <span class="pl-k">===</span> <span class="pl-en">Set</span>((<span class="pl-s"><span class="pl-pds">&quot;</span>a<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">0</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>b<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">101</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>c<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">100</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>d<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">111</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>e<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">1101</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>f<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">1100</span>))</td>
      </tr>
      <tr>
        <td id="L136" class="blob-num js-line-number" data-line-number="136"></td>
        <td id="LC136" class="blob-code blob-code-inner js-file-line">  out(p50(<span class="pl-en">List</span>((<span class="pl-s"><span class="pl-pds">&quot;</span>b<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">1</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>p<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">1</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>`<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">2</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>m<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">2</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>j<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">3</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>o<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">3</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>d<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">3</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>a<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">4</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>i<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">4</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>r<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">5</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>u<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">5</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>l<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">6</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>s<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">6</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span>e<span class="pl-pds">&quot;</span></span>, <span class="pl-c1">8</span>), (<span class="pl-s"><span class="pl-pds">&quot;</span> <span class="pl-pds">&quot;</span></span>, <span class="pl-c1">12</span>))))</td>
      </tr>
      <tr>
        <td id="L137" class="blob-num js-line-number" data-line-number="137"></td>
        <td id="LC137" class="blob-code blob-code-inner js-file-line">}</td>
      </tr>
</table>

  </div>

</div>

<a href="#jump-to-line" rel="facebox[.linejump]" data-hotkey="l" style="display:none">Jump to Line</a>
<div id="jump-to-line" style="display:none">
  <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="" class="js-jump-to-line-form" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
    <input class="linejump-input js-jump-to-line-field" type="text" placeholder="Jump to line&hellip;" aria-label="Jump to line" autofocus>
    <button type="submit" class="btn">Go</button>
</form></div>

  </div>
  <div class="modal-backdrop"></div>
</div>

    </div>
  </div>

    </div>

        <div class="container">
  <div class="site-footer" role="contentinfo">
    <ul class="site-footer-links right">
        <li><a href="https://status.github.com/" data-ga-click="Footer, go to status, text:status">Status</a></li>
      <li><a href="https://developer.github.com" data-ga-click="Footer, go to api, text:api">API</a></li>
      <li><a href="https://training.github.com" data-ga-click="Footer, go to training, text:training">Training</a></li>
      <li><a href="https://shop.github.com" data-ga-click="Footer, go to shop, text:shop">Shop</a></li>
        <li><a href="https://github.com/blog" data-ga-click="Footer, go to blog, text:blog">Blog</a></li>
        <li><a href="https://github.com/about" data-ga-click="Footer, go to about, text:about">About</a></li>
        <li><a href="https://github.com/pricing" data-ga-click="Footer, go to pricing, text:pricing">Pricing</a></li>

    </ul>

    <a href="https://github.com" aria-label="Homepage">
      <span class="mega-octicon octicon-mark-github" title="GitHub"></span>
</a>
    <ul class="site-footer-links">
      <li>&copy; 2015 <span title="0.08619s from github-fe142-cp1-prd.iad.github.net">GitHub</span>, Inc.</li>
        <li><a href="https://github.com/site/terms" data-ga-click="Footer, go to terms, text:terms">Terms</a></li>
        <li><a href="https://github.com/site/privacy" data-ga-click="Footer, go to privacy, text:privacy">Privacy</a></li>
        <li><a href="https://github.com/security" data-ga-click="Footer, go to security, text:security">Security</a></li>
        <li><a href="https://github.com/contact" data-ga-click="Footer, go to contact, text:contact">Contact</a></li>
        <li><a href="https://help.github.com" data-ga-click="Footer, go to help, text:help">Help</a></li>
    </ul>
  </div>
</div>



    
    
    

    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      <button type="button" class="flash-close js-flash-close js-ajax-error-dismiss" aria-label="Dismiss error">
        <span class="octicon octicon-x"></span>
      </button>
      Something went wrong with that request. Please try again.
    </div>


      <script crossorigin="anonymous" integrity="sha256-t8lSPZPmzQI1oKi30aaR95CdODTNnJyqexZ0ulCLZEw=" src="https://assets-cdn.github.com/assets/frameworks-b7c9523d93e6cd0235a0a8b7d1a691f7909d3834cd9c9caa7b1674ba508b644c.js"></script>
      <script async="async" crossorigin="anonymous" integrity="sha256-C6eaSq1zApeOz5oXqx8DDXhOSRxeMpf/V/r2lSbEKaU=" src="https://assets-cdn.github.com/assets/github-0ba79a4aad7302978ecf9a17ab1f030d784e491c5e3297ff57faf69526c429a5.js"></script>
      
      
      
    <div class="js-stale-session-flash stale-session-flash flash flash-warn flash-banner hidden">
      <span class="octicon octicon-alert"></span>
      <span class="signed-in-tab-flash">You signed in with another tab or window. <a href="">Reload</a> to refresh your session.</span>
      <span class="signed-out-tab-flash">You signed out in another tab or window. <a href="">Reload</a> to refresh your session.</span>
    </div>
  </body>
</html>

