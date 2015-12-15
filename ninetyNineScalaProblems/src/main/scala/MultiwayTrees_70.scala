



<!DOCTYPE html>
<html lang="en" class=" is-copy-enabled">
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# object: http://ogp.me/ns/object# article: http://ogp.me/ns/article# profile: http://ogp.me/ns/profile#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">
    <meta name="viewport" content="width=1020">
    
    
    <title>ScalaPlay/MultiwayTrees_70.scala at master · archeg/ScalaPlay</title>
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
    <link rel="web-socket" href="wss://live.github.com/_sockets/NzAwMDk0OmUwMTRjMWE2ZmQwMzdmM2MwMWRkMzM0NWNkZTQ5ODIyOmU3YmIzYWU5MTJmY2UwMmViY2ExMGVlODM4ZWMzMDJhY2FhYzU2OTEyY2QzNTg2OTQwZWE2YWVlNTI5ODcyNTc=--c24ebec2fc11bd09fcc91e0e9502193605773b38">
    <meta name="pjax-timeout" content="1000">
    <link rel="sudo-modal" href="/sessions/sudo_modal">

    <meta name="msapplication-TileImage" content="/windows-tile.png">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="selected-link" value="repo_source" data-pjax-transient>

    <meta name="google-site-verification" content="KT5gs8h0wvaagLKAVWq8bbeNwnZZK1r1XQysX3xurLU">
    <meta name="google-analytics" content="UA-3769691-2">

<meta content="collector.githubapp.com" name="octolytics-host" /><meta content="github" name="octolytics-app-id" /><meta content="1FDFE7A5:448A:11D5540E:5670A2DA" name="octolytics-dimension-request_id" /><meta content="700094" name="octolytics-actor-id" /><meta content="archeg" name="octolytics-actor-login" /><meta content="36ffb8bf8138a474da1e7d225cbe063bf44ca2befebe1f9bda1e644a749d0c74" name="octolytics-actor-hash" />
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

          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/logout" class="logout-form" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="N9LIJcMTO06PN7TISXPqNPXSHYZmJyHfjPG5FDiTGL9O0jibxWl92iwPkL7+LCCXwLuHmyuDwCb6mYKbHCOc1A==" /></div>
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
        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/notifications/subscribe" class="js-social-container" data-autosubmit="true" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="oSt9ZOjM5zoqz+Yvi3OVZ6XG0si8yTiatM1oiOe0bFwPo3JzCae4ollDWu4y+ByBn0udgq6NYDjg67bZzJ+N1A==" /></div>      <input id="repository_id" name="repository_id" type="hidden" value="48056280" />

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

    <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/unstar" class="js-toggler-form starred js-unstar-button" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="Ub5EYu/T4CCp4FhyLny9ZscaKPm7CzpDr4rs2xt1fHcRt2YRqZRbwtEEzFOIFBpHniy3uSKZqNxkwYSikoIuMw==" /></div>
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
    <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/star" class="js-toggler-form unstarred js-star-button" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="xVy/klTAzqfhC6PMzSBm3tt2C313wtj7fV4LYnDJN1HVa2CeqEbK1EZxDEI8ad8CouBtnJngv8nYfxfz6lJP1A==" /></div>
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
          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/fork" class="btn-with-count" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="FaByNxdvUsdI9EsFLGKsnHhPPa1YLPS2HAlp8M/0bIw1XKqSz2gXHd2By4XVSoKtkci4+qgusQt8ihl6Wjcehg==" /></div>
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

    

<a href="/archeg/ScalaPlay/blob/3e975fc4e13904bcb93b66fe4b239a9a6aeeb7e3/ninetyNineScalaProblems/src/main/scala/MultiwayTrees_70.scala" class="hidden js-permalink-shortcut" data-hotkey="y">Permalink</a>

<!-- blob contrib key: blob_contributors:v21:528862393019dfd2eb121589e2a46e98 -->

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
               href="/archeg/ScalaPlay/blob/master/ninetyNineScalaProblems/src/main/scala/MultiwayTrees_70.scala"
               data-name="master"
               data-skip-pjax="true"
               rel="nofollow">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <span class="select-menu-item-text css-truncate-target" title="master">
                master
              </span>
            </a>
        </div>

          <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/branches" class="js-create-branch select-menu-item select-menu-new-item-form js-navigation-item js-new-item-form" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="SjP889qarnCVWaGOEka2gJBH8jsIJRBtiu2efMtYpgZiUri73sAOGjdH88khjhf/+JqexsK8WlKiBlTYHsvVvg==" /></div>
            <span class="octicon octicon-git-branch select-menu-item-icon"></span>
            <div class="select-menu-item-text">
              <span class="select-menu-item-heading">Create branch: <span class="js-new-item-name"></span></span>
              <span class="description">from ‘master’</span>
            </div>
            <input type="hidden" name="name" id="name" class="js-new-item-value">
            <input type="hidden" name="branch" id="branch" value="master">
            <input type="hidden" name="path" id="path" value="ninetyNineScalaProblems/src/main/scala/MultiwayTrees_70.scala">
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
    <span class="repo-root js-repo-root"><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">ScalaPlay</span></a></span></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">ninetyNineScalaProblems</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems/src" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">src</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems/src/main" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">main</span></a></span><span class="separator">/</span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/archeg/ScalaPlay/tree/master/ninetyNineScalaProblems/src/main/scala" class="" data-branch="master" data-pjax="true" itemscope="url"><span itemprop="title">scala</span></a></span><span class="separator">/</span><strong class="final-path">MultiwayTrees_70.scala</strong>
  </div>
</div>

<include-fragment class="commit-tease" src="/archeg/ScalaPlay/contributors/master/ninetyNineScalaProblems/src/main/scala/MultiwayTrees_70.scala">
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
      <a href="/archeg/ScalaPlay/raw/master/ninetyNineScalaProblems/src/main/scala/MultiwayTrees_70.scala" class="btn btn-sm " id="raw-url">Raw</a>
        <a href="/archeg/ScalaPlay/blame/master/ninetyNineScalaProblems/src/main/scala/MultiwayTrees_70.scala" class="btn btn-sm js-update-url-with-hash">Blame</a>
      <a href="/archeg/ScalaPlay/commits/master/ninetyNineScalaProblems/src/main/scala/MultiwayTrees_70.scala" class="btn btn-sm " rel="nofollow">History</a>
    </div>

        <a class="octicon-btn tooltipped tooltipped-nw"
           href="github-windows://openRepo/https://github.com/archeg/ScalaPlay?branch=master&amp;filepath=ninetyNineScalaProblems%2Fsrc%2Fmain%2Fscala%2FMultiwayTrees_70.scala"
           aria-label="Open this file in GitHub Desktop"
           data-ga-click="Repository, open with desktop, type:windows">
            <span class="octicon octicon-device-desktop"></span>
        </a>

        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/edit/master/ninetyNineScalaProblems/src/main/scala/MultiwayTrees_70.scala" class="inline-form js-update-url-with-hash" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="IMQLbiRHGMCL+M5xc6ObSF6cx1Tx109Ua/OyIk9BSFGsZWI8dXk5vqYpYa8d7P3nIDs0vMc8I4UXmOECwQx81w==" /></div>
          <button class="octicon-btn tooltipped tooltipped-nw" type="submit"
            aria-label="Edit this file" data-hotkey="e" data-disable-with>
            <span class="octicon octicon-pencil"></span>
          </button>
</form>        <!-- </textarea> --><!-- '"` --><form accept-charset="UTF-8" action="/archeg/ScalaPlay/delete/master/ninetyNineScalaProblems/src/main/scala/MultiwayTrees_70.scala" class="inline-form" data-form-nonce="c8ba129f3cd8063df505087e410775fa587c3890" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="3I9PvCIHvrfptVi/62q45MjjXO1/Omfmo3aEekAmPSQUVwZSyja35KNaBxM9TKgTj+85yEzoxg3eE9Q5NKt21w==" /></div>
          <button class="octicon-btn octicon-btn-danger tooltipped tooltipped-nw" type="submit"
            aria-label="Delete this file" data-disable-with>
            <span class="octicon octicon-trashcan"></span>
          </button>
</form>  </div>

  <div class="file-info">
      161 lines (132 sloc)
      <span class="file-info-divider"></span>
    6.26 KB
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
        <td id="LC8" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L9" class="blob-num js-line-number" data-line-number="9"></td>
        <td id="LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-k">import</span> <span class="pl-v">scala.annotation.</span><span class="pl-v">tailrec</span></td>
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
        <td id="LC12" class="blob-code blob-code-inner js-file-line"><span class="pl-c">  * Created by archeg on 11/22/2015.</span></td>
      </tr>
      <tr>
        <td id="L13" class="blob-num js-line-number" data-line-number="13"></td>
        <td id="LC13" class="blob-code blob-code-inner js-file-line"><span class="pl-c">  */</span></td>
      </tr>
      <tr>
        <td id="L14" class="blob-num js-line-number" data-line-number="14"></td>
        <td id="LC14" class="blob-code blob-code-inner js-file-line"><span class="pl-k">object</span> <span class="pl-en">MultiwayTrees_70</span> <span class="pl-k">extends</span> <span class="pl-e">ChapterApp</span> {</td>
      </tr>
      <tr>
        <td id="L15" class="blob-num js-line-number" data-line-number="15"></td>
        <td id="LC15" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">case</span> <span class="pl-k">class</span> <span class="pl-en">MTree</span>[<span class="pl-k">+</span><span class="pl-en">T</span>](<span class="pl-v">value</span>: <span class="pl-en">T</span>, <span class="pl-v">children</span>: <span class="pl-en">List</span>[<span class="pl-en">MTree</span>[<span class="pl-en">T</span>]]) {</td>
      </tr>
      <tr>
        <td id="L16" class="blob-num js-line-number" data-line-number="16"></td>
        <td id="LC16" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">this</span>(<span class="pl-v">value</span>: <span class="pl-en">T</span>) <span class="pl-k">=</span> <span class="pl-v">this</span>(value, <span class="pl-en">List</span>())</td>
      </tr>
      <tr>
        <td id="L17" class="blob-num js-line-number" data-line-number="17"></td>
        <td id="LC17" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">override</span> <span class="pl-k">def</span> <span class="pl-en">toString</span> <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">&quot;</span>M(<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> value.toString <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span> {<span class="pl-pds">&quot;</span></span> <span class="pl-k">+</span> children.map(_.toString).mkString(<span class="pl-s"><span class="pl-pds">&quot;</span>,<span class="pl-pds">&quot;</span></span>) <span class="pl-k">+</span> <span class="pl-s"><span class="pl-pds">&quot;</span>})<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L18" class="blob-num js-line-number" data-line-number="18"></td>
        <td id="LC18" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L19" class="blob-num js-line-number" data-line-number="19"></td>
        <td id="LC19" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L20" class="blob-num js-line-number" data-line-number="20"></td>
        <td id="LC20" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">object</span> <span class="pl-en">MTree</span> {</td>
      </tr>
      <tr>
        <td id="L21" class="blob-num js-line-number" data-line-number="21"></td>
        <td id="LC21" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">apply</span>[<span class="pl-en">T</span>](<span class="pl-v">value</span>: <span class="pl-en">T</span>) <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-en">MTree</span>(value, <span class="pl-en">List</span>())</td>
      </tr>
      <tr>
        <td id="L22" class="blob-num js-line-number" data-line-number="22"></td>
        <td id="LC22" class="blob-code blob-code-inner js-file-line">    <span class="pl-c">//def apply[T](value: T, children: List[MTree[T]]) = new MTree(value, children)</span></td>
      </tr>
      <tr>
        <td id="L23" class="blob-num js-line-number" data-line-number="23"></td>
        <td id="LC23" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L24" class="blob-num js-line-number" data-line-number="24"></td>
        <td id="LC24" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L25" class="blob-num js-line-number" data-line-number="25"></td>
        <td id="LC25" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P70C Count the nodes of a multiway tree.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L26" class="blob-num js-line-number" data-line-number="26"></td>
        <td id="LC26" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p70c</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">MTree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-k">Int</span> <span class="pl-k">=</span> <span class="pl-c1">1</span> <span class="pl-k">+</span> tree.children.map(x <span class="pl-k">=&gt;</span> p70c(x)).sum</td>
      </tr>
      <tr>
        <td id="L27" class="blob-num js-line-number" data-line-number="27"></td>
        <td id="LC27" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L28" class="blob-num js-line-number" data-line-number="28"></td>
        <td id="LC28" class="blob-code blob-code-inner js-file-line">  out(p70c(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;f&#39;</span>))))) <span class="pl-k">===</span> <span class="pl-c1">2</span></td>
      </tr>
      <tr>
        <td id="L29" class="blob-num js-line-number" data-line-number="29"></td>
        <td id="LC29" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L30" class="blob-num js-line-number" data-line-number="30"></td>
        <td id="LC30" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p70c2</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">MTree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-k">Int</span> <span class="pl-k">=</span> tree.children.foldLeft(<span class="pl-c1">1</span>)(_ <span class="pl-k">+</span> p70c2(_))</td>
      </tr>
      <tr>
        <td id="L31" class="blob-num js-line-number" data-line-number="31"></td>
        <td id="LC31" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L32" class="blob-num js-line-number" data-line-number="32"></td>
        <td id="LC32" class="blob-code blob-code-inner js-file-line">  out(p70c2(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;f&#39;</span>))))) <span class="pl-k">===</span> <span class="pl-c1">2</span></td>
      </tr>
      <tr>
        <td id="L33" class="blob-num js-line-number" data-line-number="33"></td>
        <td id="LC33" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L34" class="blob-num js-line-number" data-line-number="34"></td>
        <td id="LC34" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P70. Tree construction from a node string<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L35" class="blob-num js-line-number" data-line-number="35"></td>
        <td id="LC35" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p70</span>(<span class="pl-v">str</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">MTree</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> p70(str.toList)</td>
      </tr>
      <tr>
        <td id="L36" class="blob-num js-line-number" data-line-number="36"></td>
        <td id="LC36" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p70</span>(<span class="pl-v">str</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-en">MTree</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L37" class="blob-num js-line-number" data-line-number="37"></td>
        <td id="LC37" class="blob-code blob-code-inner js-file-line">    out(split(str.tail))</td>
      </tr>
      <tr>
        <td id="L38" class="blob-num js-line-number" data-line-number="38"></td>
        <td id="LC38" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">split</span>(<span class="pl-v">str</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>], <span class="pl-v">nesting</span>: <span class="pl-k">Int</span> <span class="pl-k">=</span> <span class="pl-c1">0</span>, <span class="pl-v">before</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> <span class="pl-c1">Nil</span>)<span class="pl-k">:</span> <span class="pl-en">Option</span>[(<span class="pl-en">List</span>[<span class="pl-k">Char</span>], <span class="pl-en">List</span>[<span class="pl-k">Char</span>])] <span class="pl-k">=</span> (str, nesting) <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L39" class="blob-num js-line-number" data-line-number="39"></td>
        <td id="LC39" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (_, <span class="pl-c1">0</span>) <span class="pl-k">if</span> before.nonEmpty <span class="pl-k">=&gt;</span> <span class="pl-en">Some</span>((before.reverse, str))</td>
      </tr>
      <tr>
        <td id="L40" class="blob-num js-line-number" data-line-number="40"></td>
        <td id="LC40" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (<span class="pl-c1">Nil</span>, _) <span class="pl-k">=&gt;</span> <span class="pl-c1">None</span></td>
      </tr>
      <tr>
        <td id="L41" class="blob-num js-line-number" data-line-number="41"></td>
        <td id="LC41" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (<span class="pl-c1">&#39;^&#39;</span> <span class="pl-k">::</span> tail, _) <span class="pl-k">=&gt;</span> split(tail, nesting <span class="pl-k">-</span> <span class="pl-c1">1</span>, <span class="pl-c1">&#39;^&#39;</span> <span class="pl-k">::</span> before)</td>
      </tr>
      <tr>
        <td id="L42" class="blob-num js-line-number" data-line-number="42"></td>
        <td id="LC42" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> (v <span class="pl-k">::</span> tail, _) <span class="pl-k">=&gt;</span> split(tail, nesting <span class="pl-k">+</span> <span class="pl-c1">1</span>, v <span class="pl-k">::</span> before)</td>
      </tr>
      <tr>
        <td id="L43" class="blob-num js-line-number" data-line-number="43"></td>
        <td id="LC43" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L44" class="blob-num js-line-number" data-line-number="44"></td>
        <td id="LC44" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L45" class="blob-num js-line-number" data-line-number="45"></td>
        <td id="LC45" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">splitToStrings</span>(<span class="pl-v">str</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">List</span>[<span class="pl-k">Char</span>]] <span class="pl-k">=</span> split(str) <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L46" class="blob-num js-line-number" data-line-number="46"></td>
        <td id="LC46" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-c1">None</span> <span class="pl-k">=&gt;</span> <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L47" class="blob-num js-line-number" data-line-number="47"></td>
        <td id="LC47" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-en">Some</span>((before, after)) <span class="pl-k">=&gt;</span> before <span class="pl-k">::</span> splitToStrings(after)</td>
      </tr>
      <tr>
        <td id="L48" class="blob-num js-line-number" data-line-number="48"></td>
        <td id="LC48" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L49" class="blob-num js-line-number" data-line-number="49"></td>
        <td id="LC49" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L50" class="blob-num js-line-number" data-line-number="50"></td>
        <td id="LC50" class="blob-code blob-code-inner js-file-line">    <span class="pl-en">MTree</span>(str.head, splitToStrings(str.tail) map {p70(_)})</td>
      </tr>
      <tr>
        <td id="L51" class="blob-num js-line-number" data-line-number="51"></td>
        <td id="LC51" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L52" class="blob-num js-line-number" data-line-number="52"></td>
        <td id="LC52" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L53" class="blob-num js-line-number" data-line-number="53"></td>
        <td id="LC53" class="blob-code blob-code-inner js-file-line">  out(p70(<span class="pl-s"><span class="pl-pds">&quot;</span>afg^^c^bd^e^^^<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">===</span> <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;f&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;g&#39;</span>))), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;c&#39;</span>), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;d&#39;</span>), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;e&#39;</span>)))))</td>
      </tr>
      <tr>
        <td id="L54" class="blob-num js-line-number" data-line-number="54"></td>
        <td id="LC54" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L55" class="blob-num js-line-number" data-line-number="55"></td>
        <td id="LC55" class="blob-code blob-code-inner js-file-line">  <span class="pl-c">// Index out of range. Don&#39;t care, mine variant is better.</span></td>
      </tr>
      <tr>
        <td id="L56" class="blob-num js-line-number" data-line-number="56"></td>
        <td id="LC56" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//  def p70_2(s: String): MTree[Char] = {</span></td>
      </tr>
      <tr>
        <td id="L57" class="blob-num js-line-number" data-line-number="57"></td>
        <td id="LC57" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//    def nextStrBound(pos: Int, nesting: Int): Int =</span></td>
      </tr>
      <tr>
        <td id="L58" class="blob-num js-line-number" data-line-number="58"></td>
        <td id="LC58" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//      if (nesting == 0) pos</span></td>
      </tr>
      <tr>
        <td id="L59" class="blob-num js-line-number" data-line-number="59"></td>
        <td id="LC59" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//      else nextStrBound(pos + 1, if (s(pos) == &#39;^&#39;) nesting - 1 else nesting + 1)</span></td>
      </tr>
      <tr>
        <td id="L60" class="blob-num js-line-number" data-line-number="60"></td>
        <td id="LC60" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//</span></td>
      </tr>
      <tr>
        <td id="L61" class="blob-num js-line-number" data-line-number="61"></td>
        <td id="LC61" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//    def splitChildStrings(pos: Int): List[String] =</span></td>
      </tr>
      <tr>
        <td id="L62" class="blob-num js-line-number" data-line-number="62"></td>
        <td id="LC62" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//      if (pos &gt;= s.length) Nil</span></td>
      </tr>
      <tr>
        <td id="L63" class="blob-num js-line-number" data-line-number="63"></td>
        <td id="LC63" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//      else {</span></td>
      </tr>
      <tr>
        <td id="L64" class="blob-num js-line-number" data-line-number="64"></td>
        <td id="LC64" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//        val end = nextStrBound(pos + 1, 1)</span></td>
      </tr>
      <tr>
        <td id="L65" class="blob-num js-line-number" data-line-number="65"></td>
        <td id="LC65" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//        s.substring(pos, end - 1) :: splitChildStrings(end)</span></td>
      </tr>
      <tr>
        <td id="L66" class="blob-num js-line-number" data-line-number="66"></td>
        <td id="LC66" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//      }</span></td>
      </tr>
      <tr>
        <td id="L67" class="blob-num js-line-number" data-line-number="67"></td>
        <td id="LC67" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//</span></td>
      </tr>
      <tr>
        <td id="L68" class="blob-num js-line-number" data-line-number="68"></td>
        <td id="LC68" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//    MTree(s(0), splitChildStrings(1).map(p70_2(_)))</span></td>
      </tr>
      <tr>
        <td id="L69" class="blob-num js-line-number" data-line-number="69"></td>
        <td id="LC69" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//  }</span></td>
      </tr>
      <tr>
        <td id="L70" class="blob-num js-line-number" data-line-number="70"></td>
        <td id="LC70" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//</span></td>
      </tr>
      <tr>
        <td id="L71" class="blob-num js-line-number" data-line-number="71"></td>
        <td id="LC71" class="blob-code blob-code-inner js-file-line"><span class="pl-c">//  out(p70_2(&quot;afg^^c^bd^e^^^&quot;)) === MTree(&#39;a&#39;, List(MTree(&#39;f&#39;, List(MTree(&#39;g&#39;))), MTree(&#39;c&#39;), MTree(&#39;b&#39;, List(MTree(&#39;d&#39;), MTree(&#39;e&#39;)))))</span></td>
      </tr>
      <tr>
        <td id="L72" class="blob-num js-line-number" data-line-number="72"></td>
        <td id="LC72" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L73" class="blob-num js-line-number" data-line-number="73"></td>
        <td id="LC73" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P71. Determine the internal path length of a tree.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L74" class="blob-num js-line-number" data-line-number="74"></td>
        <td id="LC74" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p71</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">MTree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-k">Int</span> <span class="pl-k">=</span> tree.children.foldLeft(<span class="pl-c1">0</span>)((a, x) <span class="pl-k">=&gt;</span> a <span class="pl-k">+</span> p71(x) <span class="pl-k">+</span> p70c(x))</td>
      </tr>
      <tr>
        <td id="L75" class="blob-num js-line-number" data-line-number="75"></td>
        <td id="LC75" class="blob-code blob-code-inner js-file-line">  out(p71(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;f&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;g&#39;</span>))), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;c&#39;</span>), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;d&#39;</span>), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;e&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;f&#39;</span>), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;g&#39;</span>), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;c&#39;</span>))))))))) <span class="pl-k">===</span> <span class="pl-c1">18</span></td>
      </tr>
      <tr>
        <td id="L76" class="blob-num js-line-number" data-line-number="76"></td>
        <td id="LC76" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L77" class="blob-num js-line-number" data-line-number="77"></td>
        <td id="LC77" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P72. Construct the postorder sequence of the nodes.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L78" class="blob-num js-line-number" data-line-number="78"></td>
        <td id="LC78" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p72</span>(<span class="pl-v">s</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L79" class="blob-num js-line-number" data-line-number="79"></td>
        <td id="LC79" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">tree</span> <span class="pl-k">=</span> p70(s)</td>
      </tr>
      <tr>
        <td id="L80" class="blob-num js-line-number" data-line-number="80"></td>
        <td id="LC80" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">MTree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> (tree.children flatMap {inner(_)}) <span class="pl-k">:</span><span class="pl-k">+</span> tree.value       <span class="pl-c">// :+ is O(n)</span></td>
      </tr>
      <tr>
        <td id="L81" class="blob-num js-line-number" data-line-number="81"></td>
        <td id="LC81" class="blob-code blob-code-inner js-file-line">    inner(tree)</td>
      </tr>
      <tr>
        <td id="L82" class="blob-num js-line-number" data-line-number="82"></td>
        <td id="LC82" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L83" class="blob-num js-line-number" data-line-number="83"></td>
        <td id="LC83" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L84" class="blob-num js-line-number" data-line-number="84"></td>
        <td id="LC84" class="blob-code blob-code-inner js-file-line">  out(p72(<span class="pl-s"><span class="pl-pds">&quot;</span>afg^^c^bd^e^^^<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-c1">&#39;g&#39;</span>, <span class="pl-c1">&#39;f&#39;</span>, <span class="pl-c1">&#39;c&#39;</span>, <span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">&#39;e&#39;</span>, <span class="pl-c1">&#39;b&#39;</span>, <span class="pl-c1">&#39;a&#39;</span>)</td>
      </tr>
      <tr>
        <td id="L85" class="blob-num js-line-number" data-line-number="85"></td>
        <td id="LC85" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L86" class="blob-num js-line-number" data-line-number="86"></td>
        <td id="LC86" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p72_2</span>(<span class="pl-v">s</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L87" class="blob-num js-line-number" data-line-number="87"></td>
        <td id="LC87" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">import</span> <span class="pl-v">scala.collection.immutable.</span><span class="pl-v">Queue</span></td>
      </tr>
      <tr>
        <td id="L88" class="blob-num js-line-number" data-line-number="88"></td>
        <td id="LC88" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">tree</span> <span class="pl-k">=</span> p70(s)</td>
      </tr>
      <tr>
        <td id="L89" class="blob-num js-line-number" data-line-number="89"></td>
        <td id="LC89" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">inner</span>[<span class="pl-en">T</span>](<span class="pl-v">tree</span>: <span class="pl-en">MTree</span>[<span class="pl-en">T</span>])<span class="pl-k">:</span> <span class="pl-en">Queue</span>[<span class="pl-en">T</span>] <span class="pl-k">=</span> (<span class="pl-en">Queue</span>(tree.children<span class="pl-k">:</span> _<span class="pl-k">*</span>) flatMap {inner(_)}) <span class="pl-k">:</span><span class="pl-k">+</span> tree.value   <span class="pl-c">// :+ is O(1)</span></td>
      </tr>
      <tr>
        <td id="L90" class="blob-num js-line-number" data-line-number="90"></td>
        <td id="LC90" class="blob-code blob-code-inner js-file-line">    inner(tree).toList</td>
      </tr>
      <tr>
        <td id="L91" class="blob-num js-line-number" data-line-number="91"></td>
        <td id="LC91" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L92" class="blob-num js-line-number" data-line-number="92"></td>
        <td id="LC92" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L93" class="blob-num js-line-number" data-line-number="93"></td>
        <td id="LC93" class="blob-code blob-code-inner js-file-line">  out(p72_2(<span class="pl-s"><span class="pl-pds">&quot;</span>afg^^c^bd^e^^^<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">===</span> <span class="pl-en">List</span>(<span class="pl-c1">&#39;g&#39;</span>, <span class="pl-c1">&#39;f&#39;</span>, <span class="pl-c1">&#39;c&#39;</span>, <span class="pl-c1">&#39;d&#39;</span>, <span class="pl-c1">&#39;e&#39;</span>, <span class="pl-c1">&#39;b&#39;</span>, <span class="pl-c1">&#39;a&#39;</span>)</td>
      </tr>
      <tr>
        <td id="L94" class="blob-num js-line-number" data-line-number="94"></td>
        <td id="LC94" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L95" class="blob-num js-line-number" data-line-number="95"></td>
        <td id="LC95" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">--------------</span>(<span class="pl-s"><span class="pl-pds">&quot;</span>P73. Lisp-like tree representation.<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L96" class="blob-num js-line-number" data-line-number="96"></td>
        <td id="LC96" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L97" class="blob-num js-line-number" data-line-number="97"></td>
        <td id="LC97" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p73</span>(<span class="pl-v">tree</span>: <span class="pl-en">MTree</span>[<span class="pl-k">Char</span>])<span class="pl-k">:</span> <span class="pl-k">String</span> <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L98" class="blob-num js-line-number" data-line-number="98"></td>
        <td id="LC98" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> (tree.children.isEmpty)</td>
      </tr>
      <tr>
        <td id="L99" class="blob-num js-line-number" data-line-number="99"></td>
        <td id="LC99" class="blob-code blob-code-inner js-file-line">        tree.value.toString</td>
      </tr>
      <tr>
        <td id="L100" class="blob-num js-line-number" data-line-number="100"></td>
        <td id="LC100" class="blob-code blob-code-inner js-file-line">       <span class="pl-k">else</span></td>
      </tr>
      <tr>
        <td id="L101" class="blob-num js-line-number" data-line-number="101"></td>
        <td id="LC101" class="blob-code blob-code-inner js-file-line">        (tree.value <span class="pl-k">::</span> (tree.children map {p73(_)})).mkString(<span class="pl-s"><span class="pl-pds">&quot;</span>(<span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span> <span class="pl-pds">&quot;</span></span>, <span class="pl-s"><span class="pl-pds">&quot;</span>)<span class="pl-pds">&quot;</span></span>)</td>
      </tr>
      <tr>
        <td id="L102" class="blob-num js-line-number" data-line-number="102"></td>
        <td id="LC102" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L103" class="blob-num js-line-number" data-line-number="103"></td>
        <td id="LC103" class="blob-code blob-code-inner js-file-line">  out(p73(p70(<span class="pl-s"><span class="pl-pds">&quot;</span>afg^^c^bd^e^^^<span class="pl-pds">&quot;</span></span>))) <span class="pl-k">===</span> <span class="pl-s"><span class="pl-pds">&quot;</span>(a (f g) c (b d e))<span class="pl-pds">&quot;</span></span></td>
      </tr>
      <tr>
        <td id="L104" class="blob-num js-line-number" data-line-number="104"></td>
        <td id="LC104" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L105" class="blob-num js-line-number" data-line-number="105"></td>
        <td id="LC105" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p73_back</span>(<span class="pl-v">str</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">MTree</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L106" class="blob-num js-line-number" data-line-number="106"></td>
        <td id="LC106" class="blob-code blob-code-inner js-file-line">    <span class="pl-c">// takes &quot;a (f g) c (b d e)&quot; and turns it into List(&quot;a&quot;, &quot;(f g)&quot;, &quot;c&quot;, &quot;(b d e)&quot;)</span></td>
      </tr>
      <tr>
        <td id="L107" class="blob-num js-line-number" data-line-number="107"></td>
        <td id="LC107" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">splitToGroups</span>(<span class="pl-v">s</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-k">String</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L108" class="blob-num js-line-number" data-line-number="108"></td>
        <td id="LC108" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">@</span>tailrec</td>
      </tr>
      <tr>
        <td id="L109" class="blob-num js-line-number" data-line-number="109"></td>
        <td id="LC109" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">def</span> <span class="pl-en">inner</span>(<span class="pl-v">s</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>], <span class="pl-v">intendation</span>: <span class="pl-k">Int</span>, <span class="pl-v">current</span>: <span class="pl-en">List</span>[<span class="pl-k">Char</span>], <span class="pl-v">collected</span>: <span class="pl-en">List</span>[<span class="pl-en">List</span>[<span class="pl-k">Char</span>]])<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-en">List</span>[<span class="pl-k">Char</span>]] <span class="pl-k">=</span> (s, intendation) <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L110" class="blob-num js-line-number" data-line-number="110"></td>
        <td id="LC110" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> (<span class="pl-c1">Nil</span>, _) <span class="pl-k">if</span> current <span class="pl-k">==</span> <span class="pl-c1">Nil</span> <span class="pl-k">=&gt;</span> collected.reverse</td>
      </tr>
      <tr>
        <td id="L111" class="blob-num js-line-number" data-line-number="111"></td>
        <td id="LC111" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> (<span class="pl-c1">Nil</span>, _) <span class="pl-k">=&gt;</span> (current.reverse <span class="pl-k">::</span> collected).reverse</td>
      </tr>
      <tr>
        <td id="L112" class="blob-num js-line-number" data-line-number="112"></td>
        <td id="LC112" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> (<span class="pl-c1">&#39; &#39;</span> <span class="pl-k">::</span> tail, <span class="pl-c1">0</span>) <span class="pl-k">=&gt;</span> inner(tail, <span class="pl-c1">0</span>, <span class="pl-c1">Nil</span>, current.reverse <span class="pl-k">::</span> collected)</td>
      </tr>
      <tr>
        <td id="L113" class="blob-num js-line-number" data-line-number="113"></td>
        <td id="LC113" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> (<span class="pl-c1">&#39;(&#39;</span> <span class="pl-k">::</span> tail, _) <span class="pl-k">=&gt;</span> inner(tail, intendation <span class="pl-k">+</span> <span class="pl-c1">1</span>, <span class="pl-c1">&#39;(&#39;</span> <span class="pl-k">::</span> current, collected)</td>
      </tr>
      <tr>
        <td id="L114" class="blob-num js-line-number" data-line-number="114"></td>
        <td id="LC114" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> (<span class="pl-c1">&#39;)&#39;</span> <span class="pl-k">::</span> tail, _) <span class="pl-k">=&gt;</span> inner(tail, intendation <span class="pl-k">-</span> <span class="pl-c1">1</span>, <span class="pl-c1">&#39;)&#39;</span> <span class="pl-k">::</span> current, collected)</td>
      </tr>
      <tr>
        <td id="L115" class="blob-num js-line-number" data-line-number="115"></td>
        <td id="LC115" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">case</span> (value <span class="pl-k">::</span> tail, _) <span class="pl-k">=&gt;</span> inner(tail, intendation, value <span class="pl-k">::</span> current, collected)</td>
      </tr>
      <tr>
        <td id="L116" class="blob-num js-line-number" data-line-number="116"></td>
        <td id="LC116" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L117" class="blob-num js-line-number" data-line-number="117"></td>
        <td id="LC117" class="blob-code blob-code-inner js-file-line">      inner(s.toList, <span class="pl-c1">0</span>, <span class="pl-c1">Nil</span>, <span class="pl-c1">Nil</span>) map {_.mkString}</td>
      </tr>
      <tr>
        <td id="L118" class="blob-num js-line-number" data-line-number="118"></td>
        <td id="LC118" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L119" class="blob-num js-line-number" data-line-number="119"></td>
        <td id="LC119" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L120" class="blob-num js-line-number" data-line-number="120"></td>
        <td id="LC120" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">composeP70</span>(<span class="pl-v">str</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-k">String</span> <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L121" class="blob-num js-line-number" data-line-number="121"></td>
        <td id="LC121" class="blob-code blob-code-inner js-file-line">      splitToGroups(str.drop(<span class="pl-c1">1</span>).dropRight(<span class="pl-c1">1</span>)) <span class="pl-k">match</span> {   <span class="pl-c">// Remove first and last ()</span></td>
      </tr>
      <tr>
        <td id="L122" class="blob-num js-line-number" data-line-number="122"></td>
        <td id="LC122" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> value <span class="pl-k">::</span> tail <span class="pl-k">=&gt;</span> (value <span class="pl-k">::</span></td>
      </tr>
      <tr>
        <td id="L123" class="blob-num js-line-number" data-line-number="123"></td>
        <td id="LC123" class="blob-code blob-code-inner js-file-line">        (tail</td>
      </tr>
      <tr>
        <td id="L124" class="blob-num js-line-number" data-line-number="124"></td>
        <td id="LC124" class="blob-code blob-code-inner js-file-line">          map { x <span class="pl-k">=&gt;</span> <span class="pl-k">if</span> (x.head <span class="pl-k">==</span> <span class="pl-c1">&#39;(&#39;</span>) composeP70(x) <span class="pl-k">else</span> x}      <span class="pl-c">// If it is a bracket group - recurse.</span></td>
      </tr>
      <tr>
        <td id="L125" class="blob-num js-line-number" data-line-number="125"></td>
        <td id="LC125" class="blob-code blob-code-inner js-file-line">          map {_ <span class="pl-k">+</span> <span class="pl-c1">&#39;^&#39;</span>})).mkString                                 <span class="pl-c">// Add ^ in the end of each group.</span></td>
      </tr>
      <tr>
        <td id="L126" class="blob-num js-line-number" data-line-number="126"></td>
        <td id="LC126" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L127" class="blob-num js-line-number" data-line-number="127"></td>
        <td id="LC127" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L128" class="blob-num js-line-number" data-line-number="128"></td>
        <td id="LC128" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">val</span> <span class="pl-en">p</span> <span class="pl-k">=</span> composeP70(str)</td>
      </tr>
      <tr>
        <td id="L129" class="blob-num js-line-number" data-line-number="129"></td>
        <td id="LC129" class="blob-code blob-code-inner js-file-line">    p70(p)</td>
      </tr>
      <tr>
        <td id="L130" class="blob-num js-line-number" data-line-number="130"></td>
        <td id="LC130" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L131" class="blob-num js-line-number" data-line-number="131"></td>
        <td id="LC131" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L132" class="blob-num js-line-number" data-line-number="132"></td>
        <td id="LC132" class="blob-code blob-code-inner js-file-line">  out(p73_back(<span class="pl-s"><span class="pl-pds">&quot;</span>(a (f g) c (b d e))<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">===</span> <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;f&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;g&#39;</span>))), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;c&#39;</span>), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;d&#39;</span>), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;e&#39;</span>)))))</td>
      </tr>
      <tr>
        <td id="L133" class="blob-num js-line-number" data-line-number="133"></td>
        <td id="LC133" class="blob-code blob-code-inner js-file-line">  <span class="pl-k">def</span> <span class="pl-en">p73_back_2</span>(<span class="pl-v">s</span>: <span class="pl-k">String</span>)<span class="pl-k">:</span> <span class="pl-en">MTree</span>[<span class="pl-k">Char</span>] <span class="pl-k">=</span> {</td>
      </tr>
      <tr>
        <td id="L134" class="blob-num js-line-number" data-line-number="134"></td>
        <td id="LC134" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">setNesting</span>(<span class="pl-v">nesting</span>: <span class="pl-k">Int</span>, <span class="pl-v">c</span>: <span class="pl-k">Char</span>)<span class="pl-k">:</span> <span class="pl-k">Int</span> <span class="pl-k">=</span> c <span class="pl-k">match</span> {</td>
      </tr>
      <tr>
        <td id="L135" class="blob-num js-line-number" data-line-number="135"></td>
        <td id="LC135" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-c1">&#39;(&#39;</span> <span class="pl-k">=&gt;</span> nesting <span class="pl-k">+</span> <span class="pl-c1">1</span></td>
      </tr>
      <tr>
        <td id="L136" class="blob-num js-line-number" data-line-number="136"></td>
        <td id="LC136" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> <span class="pl-c1">&#39;)&#39;</span> <span class="pl-k">=&gt;</span> nesting <span class="pl-k">-</span> <span class="pl-c1">1</span></td>
      </tr>
      <tr>
        <td id="L137" class="blob-num js-line-number" data-line-number="137"></td>
        <td id="LC137" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">case</span> _   <span class="pl-k">=&gt;</span> nesting</td>
      </tr>
      <tr>
        <td id="L138" class="blob-num js-line-number" data-line-number="138"></td>
        <td id="LC138" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L139" class="blob-num js-line-number" data-line-number="139"></td>
        <td id="LC139" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">nextSpace</span>(<span class="pl-v">pos</span>: <span class="pl-k">Int</span>, <span class="pl-v">nesting</span>: <span class="pl-k">Int</span>)<span class="pl-k">:</span> <span class="pl-k">Int</span> <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L140" class="blob-num js-line-number" data-line-number="140"></td>
        <td id="LC140" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> ((s(pos) <span class="pl-k">==</span> <span class="pl-c1">&#39; &#39;</span> <span class="pl-k">||</span> s(pos) <span class="pl-k">==</span> <span class="pl-c1">&#39;)&#39;</span>) <span class="pl-k">&amp;&amp;</span> nesting <span class="pl-k">==</span> <span class="pl-c1">0</span>) pos</td>
      </tr>
      <tr>
        <td id="L141" class="blob-num js-line-number" data-line-number="141"></td>
        <td id="LC141" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">else</span> nextSpace(pos <span class="pl-k">+</span> <span class="pl-c1">1</span>, setNesting(nesting, s(pos)))</td>
      </tr>
      <tr>
        <td id="L142" class="blob-num js-line-number" data-line-number="142"></td>
        <td id="LC142" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">nextNonSpace</span>(<span class="pl-v">pos</span>: <span class="pl-k">Int</span>)<span class="pl-k">:</span> <span class="pl-k">Int</span> <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L143" class="blob-num js-line-number" data-line-number="143"></td>
        <td id="LC143" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> (s(pos) <span class="pl-k">==</span> <span class="pl-c1">&#39; &#39;</span>) nextNonSpace(pos <span class="pl-k">+</span> <span class="pl-c1">1</span>)</td>
      </tr>
      <tr>
        <td id="L144" class="blob-num js-line-number" data-line-number="144"></td>
        <td id="LC144" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">else</span> pos</td>
      </tr>
      <tr>
        <td id="L145" class="blob-num js-line-number" data-line-number="145"></td>
        <td id="LC145" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">def</span> <span class="pl-en">listSubstrings</span>(<span class="pl-v">pos</span>: <span class="pl-k">Int</span>)<span class="pl-k">:</span> <span class="pl-en">List</span>[<span class="pl-k">String</span>] <span class="pl-k">=</span></td>
      </tr>
      <tr>
        <td id="L146" class="blob-num js-line-number" data-line-number="146"></td>
        <td id="LC146" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">if</span> (pos <span class="pl-k">&gt;</span> s.length <span class="pl-k">||</span> s(pos) <span class="pl-k">==</span> <span class="pl-c1">&#39;)&#39;</span>) <span class="pl-c1">Nil</span></td>
      </tr>
      <tr>
        <td id="L147" class="blob-num js-line-number" data-line-number="147"></td>
        <td id="LC147" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">else</span> {</td>
      </tr>
      <tr>
        <td id="L148" class="blob-num js-line-number" data-line-number="148"></td>
        <td id="LC148" class="blob-code blob-code-inner js-file-line">        <span class="pl-k">val</span> <span class="pl-en">end</span> <span class="pl-k">=</span> nextSpace(pos, <span class="pl-c1">0</span>)</td>
      </tr>
      <tr>
        <td id="L149" class="blob-num js-line-number" data-line-number="149"></td>
        <td id="LC149" class="blob-code blob-code-inner js-file-line">        s.substring(pos, end) <span class="pl-k">::</span> (<span class="pl-k">if</span> (s(end) <span class="pl-k">==</span> <span class="pl-c1">&#39;)&#39;</span>) <span class="pl-c1">Nil</span> <span class="pl-k">else</span> listSubstrings(nextNonSpace(end)))</td>
      </tr>
      <tr>
        <td id="L150" class="blob-num js-line-number" data-line-number="150"></td>
        <td id="LC150" class="blob-code blob-code-inner js-file-line">      }</td>
      </tr>
      <tr>
        <td id="L151" class="blob-num js-line-number" data-line-number="151"></td>
        <td id="LC151" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">if</span> (s(<span class="pl-c1">0</span>) <span class="pl-k">!=</span> <span class="pl-c1">&#39;(&#39;</span>) <span class="pl-en">MTree</span>(s.head)</td>
      </tr>
      <tr>
        <td id="L152" class="blob-num js-line-number" data-line-number="152"></td>
        <td id="LC152" class="blob-code blob-code-inner js-file-line">    <span class="pl-k">else</span> {</td>
      </tr>
      <tr>
        <td id="L153" class="blob-num js-line-number" data-line-number="153"></td>
        <td id="LC153" class="blob-code blob-code-inner js-file-line">      <span class="pl-k">val</span> <span class="pl-en">vEnd</span> <span class="pl-k">=</span> nextSpace(<span class="pl-c1">1</span>, <span class="pl-c1">0</span>)</td>
      </tr>
      <tr>
        <td id="L154" class="blob-num js-line-number" data-line-number="154"></td>
        <td id="LC154" class="blob-code blob-code-inner js-file-line">      <span class="pl-en">MTree</span>(s.substring(<span class="pl-c1">1</span>, vEnd).head, listSubstrings(nextNonSpace(vEnd)).map(p73_back_2(_)))</td>
      </tr>
      <tr>
        <td id="L155" class="blob-num js-line-number" data-line-number="155"></td>
        <td id="LC155" class="blob-code blob-code-inner js-file-line">    }</td>
      </tr>
      <tr>
        <td id="L156" class="blob-num js-line-number" data-line-number="156"></td>
        <td id="LC156" class="blob-code blob-code-inner js-file-line">  }</td>
      </tr>
      <tr>
        <td id="L157" class="blob-num js-line-number" data-line-number="157"></td>
        <td id="LC157" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L158" class="blob-num js-line-number" data-line-number="158"></td>
        <td id="LC158" class="blob-code blob-code-inner js-file-line">  out(p73_back_2(<span class="pl-s"><span class="pl-pds">&quot;</span>(a (f g) c (b d e))<span class="pl-pds">&quot;</span></span>)) <span class="pl-k">===</span> <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;a&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;f&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;g&#39;</span>))), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;c&#39;</span>), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;b&#39;</span>, <span class="pl-en">List</span>(<span class="pl-en">MTree</span>(<span class="pl-c1">&#39;d&#39;</span>), <span class="pl-en">MTree</span>(<span class="pl-c1">&#39;e&#39;</span>)))))</td>
      </tr>
      <tr>
        <td id="L159" class="blob-num js-line-number" data-line-number="159"></td>
        <td id="LC159" class="blob-code blob-code-inner js-file-line">
</td>
      </tr>
      <tr>
        <td id="L160" class="blob-num js-line-number" data-line-number="160"></td>
        <td id="LC160" class="blob-code blob-code-inner js-file-line">}</td>
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
      <li>&copy; 2015 <span title="0.08448s from github-fe120-cp1-prd.iad.github.net">GitHub</span>, Inc.</li>
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

